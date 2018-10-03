package zychaowill.algorithm.search;

import zychaowill.algorithm.util.Numbers;
import zychaowill.algorithm.util.PrintlnUtils;

public class BinarySearch {

	public int search(int[] a, int key) {
		return search(a, key, 0, a.length);
	}
	
	public int search(int[] a, int key, int low, int high) {
		return doSearch(a, key, low, high);
	}
	
	private int doSearch(int[] a, int key, int low, int high) {
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
	
	public int find(int[] a, int key) {
		return find(a, key, 0, a.length);
	}
	
	public int find(int[] a, int key, int low, int high) {
		return doFind(a, key, low, high);
	}
	
	private int doFind(int[] a, int key, int low, int high) {
		if (low <= high) {
			int middle = (low + high) / 2;
			if (a[middle] > key) {
				return doFind(a, key, low, middle - 1);
			} else if (a[middle] < key) {
				return doFind(a, key, middle + 1, high);
			} else {
				return middle;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = Numbers.integers(12);
		int key = a[a.length / 2]; 
		PrintlnUtils.aprintln(a);
		PrintlnUtils.println(key);
		
		BinarySearch searchEngine = new BinarySearch();
		int index = searchEngine.search(a, key, 0, a.length);
		println(index);
		
		index = searchEngine.find(a, key, 0, a.length);
		println(index);
	}
	
	private static void println(int index) {
		if (index != -1) {
			System.out.println("物理序号: " + index + ", 逻辑序号: " + (index + 1));
		} else {
			System.out.println("Could not find the number.");
		}
	}
}
