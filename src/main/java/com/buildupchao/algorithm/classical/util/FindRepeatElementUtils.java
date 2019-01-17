package com.buildupchao.algorithm.classical.util;

public class FindRepeatElementUtils {

	static class Node {
		final int value;
		Node next;

		public Node(int value, Node next) {
			super();
			this.value = value;
			this.next = next;
		}
	}
	
	public static int findRepeatNum(int[] array) {
		int target = -1;
		int N = array.length;
		int cap = 2;
		while (N > cap) {
			cap <<= 1;
		}
		Node[] table = new Node[cap];
		Node p;
		int v;
		for (int i = 0; i < N; i++) {
			int index = (cap - 1) & (v = array[i]);
			if ((p = table[index]) == null) {
				table[index] = new Node(v, null);
			} else {
				while (true) {
					if (p.value == v) {
						target = p.value;
						i = N;
						break;
					}
					if (p.next == null) {
						p.next = new Node(v, null);
						break;
					}
					p = p.next;
				}
			}
		}
		return target;
	}
}
