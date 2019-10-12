package com.buildupchao.algorithm.distribution.loadbalance;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author buildupchao
 * @date: 2019/5/12 21:57
 * @since JDK 1.8
 */
public class PollingClusterStrategyImpl implements ClusterStrategy {

    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public String select(List<String> ipList) {
        String selectedIp = null;
        try {
            int size = ipList.size();
            if (counter.get() >= size) {
                counter.set(0);
            }
            selectedIp = ipList.get(counter.get());
            counter.incrementAndGet();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (StringUtils.isBlank(selectedIp)) {
            selectedIp = ipList.get(0);
        }
        return selectedIp;
    }

    public static void main(String[] args) {
        List<String> ipList = Arrays.asList("172.31.0.191", "172.31.0.192");
        PollingClusterStrategyImpl strategy = new PollingClusterStrategyImpl();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + strategy.select(ipList));
            });
        }
    }
}
