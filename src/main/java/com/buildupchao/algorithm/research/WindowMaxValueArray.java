package com.buildupchao.algorithm.research;

import java.util.LinkedList;

public class WindowMaxValueArray {
	
	public int[] getWindowMaxValueArray(int[] arr, int w) {
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		LinkedList<Integer> list = new LinkedList<>();
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		for (int i = 0; i < arr.length - w + 1; i++) {
			list.add(arr[i]);
			list.add(arr[i + 1]);
			list.add(arr[i + 2]);
		}
		return null;
	}
}
