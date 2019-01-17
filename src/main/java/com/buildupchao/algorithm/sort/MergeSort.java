package com.buildupchao.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = { 13, 45, 2, 6, 3, 9, 76, 8, 89, 5, 7 };
		mergeSort(a);

		printArray(a);
	}

	public static void mergeSort(int[] a) {
		doMergeSort(a, 0, a.length - 1);
	}

	private static void doMergeSort(int[] a, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			doMergeSort(a, low, middle);
			doMergeSort(a, middle + 1, high);
			doMerge(a, low, middle, high);
		}
	}

	private static void doMerge(int[] a, int low, int middle, int high) {
		int[] tmp = new int[high - low + 1];

		int i = low, j = middle + 1, k = 0;

		while (i <= middle && j <= high) {
			if (a[i] < a[j]) {
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
			}
		}

		while (i <= middle) {
			tmp[k++] = a[i++];
		}

		while (j <= high) {
			tmp[k++] = a[j++];
		}

		for (k = 0, i = low; i <= high; k++, i++) {
			a[i] = tmp[k];
		}
	}

	public static void printArray(int[] a) {
		Arrays.stream(a).forEach(x -> {
			System.out.print(x + "\t");
		});
	}
}
