package com.buildupchao.algorithm.classical.example;

import com.buildupchao.algorithm.classical.SelectedMonkeyKing;

/**
 * <p>
 * 		一群猴子要选新猴王。新猴王的选择方法是：
 * 让N只候选猴子围成一圈，从某位置起顺序编号为1~N号。
 * 从第1号开始报数，每轮从1报到3，凡报到3的猴子即退出圈子，
 * 接着又从紧邻的下一只猴子开始同样的报数。如此不断循环，
 * 最后剩下的一只猴子就选为猴王。请问是原来第几号猴子当选猴王？
 * @author buildupchao
 * @date 2019/07/24 11:34
 * @since JDK 1.8
 */
public class SelectedMonkeyKingExample {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i += 5) {
			int king = new SelectedMonkeyKing(i).selectKing();
			System.out.printf("The king is %d when has %d monkeys.\n", king, i);
		}
	}
}
