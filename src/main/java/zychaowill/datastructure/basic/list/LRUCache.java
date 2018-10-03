package zychaowill.datastructure.basic.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class LRUCache<T> {
	
	private final int cacheCapacity; 
	private int cursor;
	private CacheNode<T> head;
	private CacheNode<T> first;
	private CacheNode<T> last;
	
	public LRUCache(int size) {
		super();
		this.cursor = 0;
		this.cacheCapacity = (int) (size + size * 0.75); 
	}
	
	public void put(T data) {
		if (this.head == null) {
			this.head = new CacheNode<>(data, null, null);
		} else {
			if (this.cursor >= this.cacheCapacity) {
				removeLastNode();
			}
			CacheNode<T> newNode = new CacheNode<>(data, null, this.head);
			this.head = newNode;
		}
	}
	
	public T take() {
		if (this.head == null) {
			return null;
		} else {
			CacheNode<T> holdNode = this.head;
			this.head = holdNode.next;
			return holdNode.data;
		}
	}
	
	private void removeLastNode() {
		CacheNode<T> pre = this.head;
		while (pre != null) {
			if (pre.next == null) {
				pre = null;
				break;
			} 
			pre = pre.next;
		}
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	static class CacheNode<T> {
		T data;
		CacheNode<T> pre;
		CacheNode<T> next;
	}
}
