package com.buildupchao.algorithm.dynamic;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetManyAppleProblem {
	
	private int[][] apples;

	public GetManyAppleProblem(int[][] apples) {
		super();
		this.apples = apples;
	}
	
	public void path(int x, int y) {
		assertNotLessThan(x, 0);
		assertNotLessThan(y, 0);
		
		Line root = reversed(dpMax(x, y));
		int sum = 0;
		StringBuilder buffer = new StringBuilder("");
		while (root != null) {
			log.info("root={}", root);
			sum += root.numberOfApples;
			buffer.append("(").append(root.pointX).append(",").append(root.pointY).append(")").append(",");
			root = root.next;
		}
		log.info("The number of apples is {}.", sum);
		log.info("The lines are {}.", buffer.substring(0, buffer.lastIndexOf(",")));
	}
	
	private Line reversed(Line head) {
		if (head.getNext() == null) {
			return head;
		}
		Line reHead = reversed(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		return reHead;
	}
	
	private Line dpMax(int x, int y) {
		if (x == 0 && y == 0) {
			return new Line(0, 0, apples[0][0]);
		} else if (x == 0 && y != 0) {
			return new Line(0, y, apples[0][y]).add(dpMax(0, y - 1));
		} else if (x != 0 && y == 0) {
			return new Line(x, 0, apples[x][0]).add(dpMax(x - 1, 0));
		}
		return new Line(x, y, apples[x][y]).add(max(dpMax(x - 1, y), dpMax(x, y - 1)));
	}
	
	private Line max(Line x, Line y) {
		return getNumberOfApples(x) >= getNumberOfApples(y) ? x : y;
	}
	
	private int getNumberOfApples(Line x) {
		int sum = 0;
		Line pre = x;
		while (pre != null) {
			sum += pre.getNumberOfApples();
			pre = pre.next;
		}
		return sum;
	}
	
	private void assertNotLessThan(int x, int expectedValue) {
		if (x < expectedValue) {
			throw new RuntimeException(x + " cannot be less than " + expectedValue);
		}
	}
	
	@Data
	class Line {
		int pointX;
		int pointY;
		int numberOfApples;
		Line next;
		
		public Line(int pointX, int pointY, int numberOfApples) {
			super();
			this.pointX = pointX;
			this.pointY = pointY;
			this.numberOfApples = numberOfApples;
		}
		
		public Line add(Line next) {
			this.next = next;
			return this;
		}
		
		@Override
		public String toString() {
			return "{\"pointX\":\"" + pointX + "\", \"pointY\":\"" + pointY + "\", \"numberOfApples\":\""
					+ numberOfApples + "\"}";
		}
	}
	
	public static void main(String[] args) {
		int[][] apples = {
				{1, 2, 3, 4},
				{4, 5, 6, 7},
				{7, 8, 9, 10},
				{15, 12, 18, 2}
		};
		new GetManyAppleProblem(apples).path(3, 3);
	}
}
