package com.buildupchao.algorithm.classical;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HowManyLightsInTower {

	private Integer level;
	private Integer total;
	
	public int getNumberOfLightsInLastLevel() {
		int base = total / getSimpleNumberOfLights();
		return (int) (base * Math.pow(2, level - 1));
	}
	
	private int getSimpleNumberOfLights() {
		int simple = 1;
		int sum = simple;
		for (int i = 1; i < level; i++)
			sum += simple <<= 1;
		return sum;
	}
}
