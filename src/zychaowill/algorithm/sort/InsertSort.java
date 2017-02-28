package zychaowill.algorithm.sort;

import org.junit.Test;

public class InsertSort {

	/**
	 * Directly insert sort algorithm.
	 * 
	 * @param a
	 */
	public <T extends Comparable<T>> void directInsertSort(T[] a) {
		directInsertSort(a, 0, a.length);
	}

	public <T extends Comparable<T>> void directInsertSort(T[] a, int startIndex, int endIndex) {
		for (int i = startIndex; i < endIndex; i++) {

			for (int j = startIndex; j < i; j++) {

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
	public <T extends Comparable<T>> void binaryInsertSort(T[] a) {
		binaryInsertSort(a, 0, a.length);
	}

	public <T extends Comparable<T>> void binaryInsertSort(T[] a, int startIndex, int endIndex) {
		for (int i = startIndex + 1; i < endIndex; i++) {
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
	public <T extends Comparable<T>> void shellSort(T[] a) {
		shellSort(a, 0, a.length);
	}
	
	public <T extends Comparable<T>> void shellSort(T[] a, int startIndex, int endIndex) {
		int h = 1;

		while (h <= (endIndex - startIndex) / 3) {
			h = h * 3 + 1;
		}

		// To do incremental search and sort.
		while (h > 0) {
			for (int i = startIndex + h; i < endIndex; i++) {
				for (int j = i; j < endIndex; j += h) {
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
	private void directInsertSortTest() {
		Integer[] a = new Integer[] { 8, 3, 2, 1, 7, 4, 6, 5 };
		directInsertSort(a);
		printArray("直接插入: ", a);
	}

	@Test
	private void binaryInsertSortTest() {
		Integer[] a = new Integer[] { 8, 3, 2, 1, 7, 4, 6, 5 };
		binaryInsertSort(a);
		printArray("折半插入: ", a);
	}

	@Test
	private void shellSortTest() {
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
