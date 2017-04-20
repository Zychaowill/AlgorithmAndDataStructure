package zychaowill.algorithm.sort;

import java.util.Arrays;

public class QuickSortUtil {
	
	public static void main(String[] args) {
		int[] a = {13, 45, 2, 6, 3, 9, 76, 8, 89, 5, 7};
		quickSort(a);
		
		printArray(a);
	}
	
	public static void quickSort(int[] a) {
		doSort(a, 0, a.length - 1);
	}
	
	private static void doSort(int[] a, int s, int t) {
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
	
	public static void printArray(int[] a) {
		Arrays.stream(a).forEach(x -> {
			System.out.print(x + "\t");
		});
	}
}
