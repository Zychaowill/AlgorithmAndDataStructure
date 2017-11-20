package zychaowill.algorithm.search;

import zychaowill.algorithm.exception.SearchException;

public class BinarySearch {

	public int search(int[] a, int key) {
		return doSearch(a, key);
	}
	
	public int search(int[] a, int key, int low, int high) {
		return doSearch2(a, key, low, high);
	}
	
	private int doSearch(int[] a, int key) {
		int low = 0, high = a.length - 1;
		int middle = -1;

		while (low <= high) {
			middle = (low + high) / 2;
			if (key < a[middle]) {
				high = middle - 1;
			} else if (key > a[middle]) {
				low = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;
	}
	
	private int doSearch2(int[] a, int key, int low, int high) {
		if (low <= high) {
			int middle = (low + high) / 2;
			if (a[middle] > key) {
				return doSearch2(a, key, low, middle - 1);
			} else if (a[middle] < key) {
				return doSearch2(a, key, middle + 1, high);
			} else {
				return middle;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int key = 115; 
		int[] a = { 1, 4, 6, 34, 78, 102, 115, 137, 500 };
		
//		int index = new BinarySearch().search(a, key);
		int index = new BinarySearch().search(a, key, 0, a.length);
		if (index != -1) {
			System.out.println("物理序号: " + index + ", 逻辑序号: " + (index + 1));
		} else {
			throw new SearchException("Could not find the number.");
		}
	}
}
