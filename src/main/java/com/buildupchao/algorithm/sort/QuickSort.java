package com.buildupchao.algorithm.sort;

import org.junit.Test;

public class QuickSort {

	private static final int CUTOFF = 10;
	
	public <T extends Comparable<T>> void sort(T[] a) {
		sort(a, 0, a.length - 1);
	}

	public <T extends Comparable<T>> void sort(T[] a, int low, int high) {
		if (high - low <= CUTOFF - 1) {
			new InsertSort().directInsertSort(a, low, high);
			return ;
		}
		// 采用三平均分区法查找中轴
		int m = medianOf3(a, low, low + (high - low) / 2, high);
		swap(a, low, m);
		
		if (low < high) {
			int q = partition(a, low, high);
			sort(a, low, q - 1);
			sort(a, q + 1, high);
		}
	}
	
	/**
	 * Dijkstra三分区快速排序
	 * @param a
	 * @param low
	 * @param high
	 */
	public <T extends Comparable<T>> void threeWaySort(T[] a, int low, int high) {
		if (high - low <= CUTOFF - 1) {
			new InsertSort().directInsertSort(a, low, high);
			return ;
		}
		
		// 三分区
		int lt = low, i = low + 1, gt = high;
		T v = a[low];
		
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			
			if (cmp < 0) {
				swap(a, lt++, i++);
			} else if (cmp > 0) {
				swap(a, i, gt--);
			} else {
				i++;
			}
		}
		
		sort(a, low, lt - 1);
		sort(a, gt + 1, high);
	}
	
	public <T extends Comparable<T>> void threeWaySortAdvance(T[] a, int low, int high) {
		if (high - low <= CUTOFF - 1) {
			new InsertSort().directInsertSort(a, low, high);
			return ;
		}
		
		// Bentley-McIlroy 3-way partitioning
	    int i = low, j = high + 1;
	    int p = low, q = high + 1;
	    T v = a[low];
	    
	    while (true) {
	    	while (less(a[++i], v)) {
	    		if (i == high) {
	    			break;
	    		}
	    	}
	    	
	    	while (less(v, a[--j])) {
	    		if (j == low) {
	    			break;
	    		}
	    	}
	    	
	    	// pointers cross
	    	if (i == j && equal(a[i], v)) {
	    		swap(a, ++p, i);
	    	}
	    	
	    	if (i >= j) {
	    		break;
	    	}
	    	
	    	swap(a, i, j);
	    	if (equal(a[i], v)) {
	    		swap(a, ++p, i);
	    	}
	    	if (equal(a[j], v)) {
	    		swap(a, --q, j);
	    	}
	    }
	    
	    // 将相等的元素交换到中间
		i = j + 1;
		for (int k = low; k <= p; k++) {
			swap(a, k, j--);
		}
		for (int k = high; k >= q; k--) {
			swap(a, k, i++);
		}
		
		sort(a, low, j);
		sort(a, i, high);
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
				swap(a, i, j);
			}
		}

		i++;
		swap(a, i, high);

		return i;
	}
	
	/**
	 * Tools
	 */
	private <T extends Comparable<T>> void swap(T[] a, int i, int j) {
		T t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private <T extends Comparable<T>> int medianOf3(T[] a, int low, int center, int high) {
		return (less(a[low], a[center])) ?
				(less(a[center], a[high]) ? center : less(a[low], a[high]) ? high : low) :
				(less(a[high], a[center]) ? center : less(a[high], a[low]) ? high : low);
	}
	
	private <T extends Comparable<T>> boolean less(T t1, T t2) {
		return t1.compareTo(t2) < 0;
	}
	
	private <T extends Comparable<T>> boolean equal(T t1, T t2) {
		return t1.compareTo(t2) == 0;
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
