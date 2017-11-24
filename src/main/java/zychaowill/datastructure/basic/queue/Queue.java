package zychaowill.datastructure.basic.queue;

public interface Queue<E> {
	
	boolean isEmpty();
	
	int size();
	
	void enQueue(E element);
	
	E deQueue();
}
