package com.buildupchao.algorithm.classical;

/**
 * @author buildupchao
 * @date 2019/07/24 17:12
 * @since JDK 1.8
 */
public class SelectedMonkeyKing {

	int numOfMonkey;

	public SelectedMonkeyKing(int numOfMonkey) {
		super();
		this.numOfMonkey = numOfMonkey;
	}
	
	public int selectKing() {
		int restOfMonkey = numOfMonkey;
		final int total = numOfMonkey;
		int point = -1;
		int result = 0;
		boolean[] list = new boolean[numOfMonkey];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = true;
		}
		
		while (restOfMonkey > 0) {
			// 报数
			for (int i = 0; i <= 2; i++) {
				point = (point + 1) % total;
				// 如果已经出列就让下一个未出列的猴子报数
				while (!list[point]) {
					point = (point + 1) % total;
				}
				// 出列
				if (i == 2 && list[point]) {
					list[point] = false;
					
					result = point + 1;
					restOfMonkey--;
				}
			}
			
			if (restOfMonkey == 0) {
				break;
			}
		}
		return result;
	}
}
