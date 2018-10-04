package zychaowill.datastructure.basic.list.examples;

import zychaowill.datastructure.basic.list.LRUCache;

public class LRUCacheExample {
	
	public static void main(String[] args) {
		LRUCache<Integer, Integer> lruCache = new LRUCache<>(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		lruCache.put(4, 4);
		lruCache.put(5, 5);
		lruCache.println();
		
		lruCache.take(3);
		lruCache.println();
		
		lruCache.take(2);
		lruCache.println();
		
		lruCache.put(6, 6);
		lruCache.println();
		
		lruCache.removeNode(3);
		lruCache.take(2);
		lruCache.println();
	}
}
