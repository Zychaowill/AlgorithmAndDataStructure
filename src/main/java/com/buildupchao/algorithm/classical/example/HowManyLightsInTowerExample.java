package com.buildupchao.algorithm.classical.example;

import com.buildupchao.algorithm.classical.HowManyLightsInTower;

public class HowManyLightsInTowerExample {
	
	public static void main(String[] args) {
		HowManyLightsInTower tower = new HowManyLightsInTower(8, 765);
		System.out.printf("There are %d lights in last level of tower.", tower.getNumberOfLightsInLastLevel());
	}
}
