package zychaowill.algorithm.newsort;

import java.util.Arrays;

public class QuickSort {
	
	public void sort(int[] a) {
		doSort(a, 0, a.length - 1);
		printArray(a);
	}
	
	private void doSort(int[] a, int s, int t) {
		int i = s, j = t;
		int base;
		
		if (s < t) {
			base = a[s];
			
			while (i != j) {
				while (j > i && a[j] >= base) {
					j--;
				}
				a[i] = a[j];
				while (i < j && a[i] <= base) {
					i++;
				}
				a[j] = a[i];
			}
			a[i] = base;
			doSort(a, s, i - 1);
			doSort(a, i + 1, t);
		}
	}
	
	private void printArray(int[] a) {
		Arrays.stream(a).forEach(x -> {
			System.out.print(x + "\t");
		});
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{8, 3, 2, 1, 7, 4, 6, 5};
		new QuickSort().sort(a);
	}
}
