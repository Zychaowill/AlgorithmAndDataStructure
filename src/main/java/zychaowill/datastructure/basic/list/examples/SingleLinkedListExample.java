package zychaowill.datastructure.basic.list.examples;

import zychaowill.datastructure.basic.list.SingleLinkedList;

public class SingleLinkedListExample {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		list.println();
		
		list.remove(3);
		list.println();
	}
}
