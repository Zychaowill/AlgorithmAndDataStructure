package com.buildupchao.algorithm.leetcode.repeatnumber;

public class RepeatNumberChecker {

	public boolean containsDuplicate(int[] nums) {
		boolean result = false;
		int length = nums.length;

		quickSort(nums, 0, length - 1);
		for (int i = 0; i < length; i++) {
			if (containsNumber(nums[i], nums, i + 1, length - 1)) {
				result = true;
				break;
			}
		}
		return result;
	}

	private void quickSort(int[] a, int s, int t) {
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
			quickSort(a, s, i - 1);
			quickSort(a, i + 1, t);
		}
	}

	private boolean containsNumber(int num, int[] nums, int low, int high) {
		boolean result = false;

		int middle = -1;
		while (low <= high) {
			middle = (low + high) / 2;
			if (nums[middle] == num) {
				result = true;
				break;
			} else if (nums[middle] > num) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		boolean result = new RepeatNumberChecker().containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 });
		System.out.println(result);
	}
}
