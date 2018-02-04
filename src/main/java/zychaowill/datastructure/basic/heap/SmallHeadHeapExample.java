package zychaowill.datastructure.basic.heap;

import java.util.Arrays;
import java.util.List;

public class SmallHeadHeapExample {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(20, 16, 15, 13, 11, 9, 7, 5, 3);
		SmallHeadHeap<Integer> heap = new SmallHeadHeap<>(numbers);
		System.out.println("inOrder: " + heap.inOrder());
	}
}
