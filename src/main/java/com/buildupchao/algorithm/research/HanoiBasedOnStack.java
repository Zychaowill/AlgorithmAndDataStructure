package com.buildupchao.algorithm.research;

/**
 * Required: must move element relied on middle element. 
 * @since
 */
public class HanoiBasedOnStack {
	
	private String left;
	private String middle;
	private String right;
	
	public int process(int n, String from, String to) {
		if (n == 1) {
			if (from.equals(middle) || to.equals(middle)) {
				println(1, from, to);
				return 1;
			} else {
				println(1, from, middle);
				println(1, middle, to);
				return 2;
			}
		}
		if (from.equals(middle) || to.equals(middle)) {
			String another = (from.equals(left) || to.equals(left)) ? right : left;
			
			int firstPart = process(n - 1, from, another);
			int secondPart = 1;
			println(n, from, to);
			int thirdPart = process(n - 1, another, to);
			return firstPart + secondPart + thirdPart;
		} else {
			int firstPart = process(n - 1, from, to);
			int secondPart = 1;
			println(n, from, middle);
			int thirdPart = process(n - 1, to, from);
			int fourthPart = 1; 
			println(n, from, to);
			int fifthPart = process(n - 1, from, to);
			return firstPart + secondPart + thirdPart + fourthPart + fifthPart;
		}
	}
	
	public int hanoiUsingRecursive(int n, String left, String middle, String right) {
		if (n < 1) {
			println(0);
			return 0;
		}
		this.left = left;
		this.middle = middle;
		this.right = right;
		
		int steps = process(n, left, right);
		println(steps);
		return steps;
	}
	
	private static void println(int n, String from, String to) {
		System.out.printf("move %d-th from %s to %s\n", n, from, to);
	}
	
	private static void println(int steps) {
		System.out.printf("total steps are %d\n", steps);
	}
}
