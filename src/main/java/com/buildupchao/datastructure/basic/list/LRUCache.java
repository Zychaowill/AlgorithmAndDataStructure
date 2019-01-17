package com.buildupchao.datastructure.basic.list;

import java.util.HashSet;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * LRU Cache
 * @author Jang Zhang
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> {

	private final int cacheCapacity;
	private int cursor;
	private HashSet<K> keyContainer;
	private CacheNode<K, V> head;
	private CacheNode<K, V> first;
	private CacheNode<K, V> last;

	public LRUCache(int size) {
		super();
		this.cursor = 0;
		this.cacheCapacity = (int) (size + size * 0.75);
		this.keyContainer = new HashSet<>(cacheCapacity);
		this.head = null;
		this.first = this.last = this.head;
	}

	public void put(K key, V value) {
		if (this.head == null) {
			this.head = new CacheNode<>(key, value, null, null);
			this.keyContainer.add(key);
			this.cursor++;
		} else {
			if (this.cursor >= this.cacheCapacity) {
				removeLastNode();
			}
			CacheNode<K, V> newNode = new CacheNode<>(key, value, null, this.head);
			this.head.pre = newNode;
			this.head = newNode;
			this.keyContainer.add(key);
			this.cursor++;
			// move cursor of first and last
			this.first = newNode;
			moveTailCursor();
		}
	}

	public V take(K key) {
		if (this.head == null || !this.keyContainer.contains(key)) {
			return null;
		} else {
			CacheNode<K, V> holdNode = findByKey(key);
			K k = holdNode.key;
			V v = holdNode.value;
			
			removeNode(holdNode);
			put(k, v);
			return v;
		}
	}

	public void removeNode(K key) {
		if (this.head != null && this.keyContainer.contains(key)) {
			removeNode(findByKey(key));
		}
	}
	
	public void println() {
		StringBuffer nodeInfo = new StringBuffer();
		CacheNode<K, V> pointer = this.head;
		while (pointer != null) {
			nodeInfo.append("[")
				.append(pointer.key).append(":").append(pointer.value)
				.append("]");
			pointer = pointer.next;
		}
		System.out.println("【" + this.getClass().getSimpleName() + "】" + nodeInfo.toString());
	}
	
	private void removeLastNode() {
		CacheNode<K, V> pre = this.head;
		while (pre != null) {
			if (pre.next == null) {
				removeNode(pre);
				break;
			}
			pre = pre.next;
		}
	}

	private void moveTailCursor() {
		CacheNode<K, V> pointer = this.head;
		while (pointer != null) {
			if (pointer.next == null) {
				this.last = pointer;
				break;
			}
			pointer = pointer.next;
		}
	}

	private CacheNode<K, V> findByKey(K key) {
		CacheNode<K, V> pointer = this.head;
		while (!Objects.equals(pointer.key, key)) {
			pointer = pointer.next;
		}
		return pointer;
	}
	
	private void removeNode(CacheNode<K, V> holdNode) {
		this.keyContainer.remove(holdNode.key);
		this.cursor--;
		if (holdNode.next == null) {
			holdNode.pre.next = null;
		} else {
			holdNode.pre.next = holdNode.next;
			holdNode.next.pre = holdNode.pre;
		}
		holdNode = null;
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	static class CacheNode<K, V> {
		K key;
		V value;
		CacheNode<K, V> pre;
		CacheNode<K, V> next;
	}
}
