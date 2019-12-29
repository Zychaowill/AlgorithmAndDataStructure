package com.buildupchao.datastructure.basic.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * time wheel, used for delay-task.
 *
 * @author buildupchao
 * @date 2019/12/29 02:35
 * @since JDK 1.8
 */
public final class RingBufferWheel {

    private static final Logger LOGGER = LoggerFactory.getLogger(RingBufferWheel.class);

    /**
     * the capacity of ringBuffer, element collection
     */
    private static final int DEFAULT_RING_BUFFER_CAPACITY = 64;

    private CopyOnWriteArraySet<Task>[] ringBuffer;

    private int bufferSize;

    /**
     * business handler in background
     */
    private ExecutorService executorService;

    private volatile int taskSize = 0;

    /**
     * the label that enables all tasks be stopped
     */
    private volatile boolean stop = false;

    /**
     * the label than enables all tasks be started
     */
    private volatile AtomicBoolean start = new AtomicBoolean(false);

    /**
     * the tick times of ringBuffer
     */
    private AtomicInteger tickTimes = new AtomicInteger();

    /**
     * delay task mapping<taskId, task>
     */
    private Map<Integer, Task> taskMap = new HashMap<>(16);
    private AtomicInteger taskIdGenerator = new AtomicInteger();

    /**
     * ringBuffer lock
     */
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * Create a new delay task scheduler wheel using default capacity.
     *
     * @param executorService
     */
    public RingBufferWheel(ExecutorService executorService) {
        this(executorService, DEFAULT_RING_BUFFER_CAPACITY);
    }

    /**
     * Create a new delay task scheduler wheel using capacity offered.
     *
     * @param executorService
     * @param bufferSize
     */
    public RingBufferWheel(ExecutorService executorService, int bufferSize) {
        if (!isAvailableBufferSize(bufferSize)) {
            throw new RuntimeException("bufferSize must be the power of 2: " + bufferSize);
        }
        this.executorService = executorService;
        this.bufferSize = bufferSize;
        this.ringBuffer = new CopyOnWriteArraySet[bufferSize];
    }

    /**
     * @param task logic of business extends {@link Task}
     * @return
     */
    public int addTask(Task task) {
        int delay = task.getDelay();
        int taskId;
        try {
            lock.lock();
            int position = getPosition(delay, bufferSize);
            task.setPosition(position);
            CopyOnWriteArraySet<Task> tasks = getTasks(position);

            if (tasks == null) {
                int cycleNum = getCycleNum(delay, bufferSize);
                task.setCycleNum(cycleNum);
                tasks = new CopyOnWriteArraySet<>();
                tasks.add(task);
                registerTasks(delay, tasks);
            } else {
                int cycleNum = getCycleNum(delay, bufferSize);
                task.setCycleNum(cycleNum);
                tasks.add(task);
            }
            taskId = taskIdGenerator.incrementAndGet();
            taskMap.put(taskId, task);
            taskSize++;
        } finally {
            lock.unlock();
        }
        start();
        return taskId;
    }

    private void start() {
        if (!start.get()) {
            if (start.compareAndSet(start.get(), true)) {
                LOGGER.info("start time wheel thread in background");
                Thread job = new Thread(new TriggerJob(), "time-wheel-thread");
                job.start();
                start.set(true);
            }
        }
    }

    public boolean cancel(int taskId) {
        boolean flag = false;

        try {
            lock.lock();

            Task task = taskMap.get(taskId);
            if (task == null) {
                return false;
            }

            CopyOnWriteArraySet<Task> tasks = getTasks(task.getPosition());
            for (Task delayTask : tasks) {
                if (delayTask.getDelay() == task.getDelay() && delayTask.getCycleNum() == task.getCycleNum()) {
                    tasks.remove(delayTask);
                    taskSize--;
                    flag = true;
                }
            }
        } finally {
            lock.unlock();
        }
        return flag;
    }

    public void stop(boolean force) {
        if (force) {
            LOGGER.info("all delay tasks are forced stop");
            stop = true;
            executorService.shutdownNow();
        } else {
            LOGGER.info("all delay tasks are stopping");
            if (taskSize > 0) {
                try {
                    lock.lock();
                    condition.await();
                    stop = true;
                } catch (InterruptedException ex) {
                    LOGGER.error("InterruptedException: ", ex);
                } finally {
                    lock.unlock();
                }
            }
            executorService.shutdown();
        }
    }

    private CopyOnWriteArraySet<Task> removeTasks(int index) {
        CopyOnWriteArraySet<Task> result = new CopyOnWriteArraySet<>();
        CopyOnWriteArraySet<Task> tasks = getTasks(index);
        if (tasks == null) {
            return result;
        }

        for (Task task : tasks) {
            if (task.getCycleNum() == 0) {
                tasks.remove(task);
                result.add(task);
                decreaseAndNotify();
            } else {
                task.setCycleNum(task.getCycleNum() - 1);
            }
        }
        return result;
    }

    private void decreaseAndNotify() {
        try {
            lock.lock();
            taskSize--;
            if (taskSize == 0) {
                condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }


    public int getTaskSize() {
        return taskSize;
    }

    private void registerTasks(int key, CopyOnWriteArraySet<Task> tasks) {
        int index = getPosition(key, bufferSize);
        ringBuffer[index] = tasks;
    }

    private int getCycleNum(int delay, int mod) {
        return (delay >> Integer.bitCount(mod - 1));
    }

    private CopyOnWriteArraySet<Task> getTasks(int position) {
        return ringBuffer[position];
    }

    private int getPosition(int key, int capacity) {
        key = key + tickTimes.get();
        return key & (capacity - 1);
    }

    private boolean isAvailableBufferSize(int bufferSize) {
        if (bufferSize < 0) {
            return false;
        }
        return ((bufferSize & (bufferSize - 1)) == 0);
    }

    /**
     * the task that do some business logic after delay time satisfied
     */
    public static abstract class Task extends Thread {

        private int position;
        private int cycleNum;
        private int delay;

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getCycleNum() {
            return cycleNum;
        }

        public void setCycleNum(int cycleNum) {
            this.cycleNum = cycleNum;
        }

        public int getDelay() {
            return delay;
        }

        public void setDelay(int delay) {
            this.delay = delay;
        }
    }

    private class TriggerJob implements Runnable {

        @Override
        public void run() {
            int index = 0;
            while (!stop) {
                try {
                    Set<Task> tasks = removeTasks(index);
                    for (Task task : tasks) {
                        executorService.execute(task);
                    }

                    if (++index > bufferSize - 1) {
                        index = 0;
                    }

                    tickTimes.incrementAndGet();
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception ex) {
                    LOGGER.error("Exception: ", ex);
                }
            }
            LOGGER.info("exit trigger job, time wheel stop.");
        }
    }
}
