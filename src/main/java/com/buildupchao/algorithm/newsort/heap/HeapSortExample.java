package com.buildupchao.algorithm.newsort.heap;

import java.util.Arrays;
import java.util.List;

public class HeapSortExample {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(20, 16, 15, 13, 11, 9, 7, 5, 3);
		HeapSort<Integer> sort = new HeapSort<>(numbers);
		System.out.println("sort: " + sort.heapSort());
	}
}
