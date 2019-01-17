package com.buildupchao.algorithm.classical.example;

import com.buildupchao.algorithm.classical.HowManyOneInBinary;

public class HowManyOneInBinaryExample {
	
	public static void main(String[] args) {
		HowManyOneInBinary countOne = new HowManyOneInBinary();
		
		for (int i = 0; i < 16; i++) {
			countOne.setNumber(i);
			System.out.printf("The result is %d when number is %d.\n", countOne.numberOfOne(), i);
		}
	}
}
