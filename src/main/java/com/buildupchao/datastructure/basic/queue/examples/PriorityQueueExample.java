package com.buildupchao.datastructure.basic.queue.examples;

import com.buildupchao.datastructure.basic.queue.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		int[] a = { 4, 2, 1, 3, 8, new Integer(5), 7, 6 };
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		System.out.print("入队顺序：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
			pq.enQueue(a[i]);
		}
		System.out.println();
		
		System.out.print("出队顺序数组实现：");
		while (!pq.isEmpty()) {
			System.out.print(pq.deQueue() + " ");
		}
	}
}
