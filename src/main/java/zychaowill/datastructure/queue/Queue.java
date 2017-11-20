package zychaowill.datastructure.queue;

public interface Queue<E> {
	
	boolean isEmpty();
	
	int size();
	
	void enQueue(E element);
	
	E deQueue();
}
