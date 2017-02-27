package zychaowill.sort;

import org.junit.Test;

public class InsertSort {

	/**
	 * Directly insert sort algorithm.
	 * 
	 * @param a
	 */
	private <T extends Comparable<T>> void directInsertSort(T[] a) {
		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < i; j++) {

				if (a[i].compareTo(a[j]) < 0) {

					T t = a[i];
					System.arraycopy(a, j, a, j + 1, i - j);
					a[j] = t;
				}
			}
		}
	}

	/**
	 * Binary insert sort algorithm
	 * 
	 * @param a
	 */
	private <T extends Comparable<T>> void binaryInsertSort(T[] a) {
		for (int i = 1; i < a.length; i++) {
			T t = a[i];
			int low = 0, high = i - 1;

			while (low <= high) {
				int middle = (low + high) / 2;

				if (t.compareTo(a[middle]) > 0) {
					low = middle + 1;
				} else {
					high = middle - 1;
				}
			}

			System.arraycopy(a, low, a, low + 1, i - low);
			a[low] = t;
		}
	}

	/**
	 * Shell sort algorithm Increment h = h * 3 + 1, the formula posted by Knuth
	 * 
	 * @param a
	 */
	private <T extends Comparable<T>> void shellSort(T[] a) {
		int h = 1;

		while (h <= a.length / 3) {
			h = h * 3 + 1;
		}

		// To do incremental search and sort.
		while (h > 0) {
			for (int i = h; i < a.length; i++) {
				for (int j = i; j < a.length; j += h) {
					// Check if need to sort
					if (a[j].compareTo(a[j - h]) < 0) {
						T t = a[j];
						int k = j;

						while (k >= i && t.compareTo(a[k - h]) < 0) {
							a[k] = a[k - h];
							k -= h;
						}
						a[k] = t;
					}
				}
			}
			h = (h - 1) / 3;
		}
	}

	@Test
	public void directInsertSortTest() {
		Integer[] a = new Integer[] { 8, 3, 2, 1, 7, 4, 6, 5 };
		directInsertSort(a);
		printArray("直接插入: ", a);
	}
	
	@Test
	public void binaryInsertSortTest() {
		Integer[] a = new Integer[] { 8, 3, 2, 1, 7, 4, 6, 5 };
		binaryInsertSort(a);
		printArray("折半插入: ", a);
	}
	
	@Test
	public void shellSortTest() {
		Integer[] a = new Integer[] { 8, 3, 2, 1, 7, 4, 6, 5 };
		shellSort(a);
		printArray("希尔排序: ", a);
	}
	
	private <T extends Comparable<T>> void printArray(String message, T[] a) {
		System.out.print(message);
		for (T t : a) {
			System.out.print(t + "\t");
		}
		System.out.println("");
	}
}
