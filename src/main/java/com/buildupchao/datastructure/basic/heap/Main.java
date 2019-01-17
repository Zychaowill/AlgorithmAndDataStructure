package com.buildupchao.datastructure.basic.heap;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 5, 10, 7, 9, 15, 11, 13, 20);
		SmallHeadHeap<Integer> heap = new SmallHeadHeap<>(numbers);
		String inOrder = heap.inOrder();
		System.out.println("inOrder: " + inOrder);
		
		heap.offer(16);
		System.out.println("inOrder: " + heap.inOrder());
		
		Integer pollE = heap.poll();
		System.out.println("poll: " + pollE);
		System.out.println("inOrder: " + heap.inOrder());
		
		heap.remove(16);
		System.out.println("inOrders: " + heap.inOrder());
	}
}
