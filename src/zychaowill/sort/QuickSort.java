package zychaowill.sort;

import org.junit.Test;

public class QuickSort {

	public <T extends Comparable<T>> void sort(T[] a) {
		sort(a, 0, a.length - 1);
	}

	private <T extends Comparable<T>> void sort(T[] a, int low, int high) {
		if (low < high) {
			int q = partition(a, low, high);
			sort(a, low, q - 1);
			sort(a, q + 1, high);
		}
	}

	/**
	 * @description Dividing the array into two parts, putting a large group on
	 *              the right and a small group on the left.
	 * @param a
	 *            Array
	 * @param low
	 *            Start index
	 * @param high
	 *            End index
	 * @return
	 */
	private <T extends Comparable<T>> int partition(T[] a, int low, int high) {
		T base = a[high];

		int i = low - 1;

		for (int j = low; j <= high - 1; j++) {
			if (a[j].compareTo(base) < 0) {
				i++;
				T t = a[j];
				a[j] = a[i];
				a[i] = t;
			}
		}

		i++;
		a[high] = a[i];
		a[i] = base;

		return i;
	}

	@Test
	public void quickSortTest() {
		Integer[] heap = new Integer[] { 0, 3, 1, 5, 12, 7 };
		new QuickSort().sort(heap);

		for (Integer i : heap) {
			System.out.print(i + "\t");
		}
	}
}
