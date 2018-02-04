package zychaowill.algorithm.newsort.heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import zychaowill.datastructure.basic.heap.SmallHeadHeap;

public class HeapSort<E> {

	SmallHeadHeap<E> heap;
	
	public HeapSort(Collection<? extends E> c) {
		heap = new SmallHeadHeap<>(c);
	}
	
	public String heapSort() {
		List<E> numbers = new ArrayList<>();
		int size = heap.size();
		for (int i = 0; i < size; i++) {
			numbers.add(heap.poll());
		}
		return numbers.stream().map(String::valueOf).collect(Collectors.joining(","));
	}
	
}
