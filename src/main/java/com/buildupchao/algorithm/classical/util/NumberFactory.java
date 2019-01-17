package com.buildupchao.algorithm.classical.util;

/**
 * Created by yachao on 2018/6/18.
 */
public class NumberFactory {

    public static int[] randomInt(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i;
        }
        return numbers;
    }

    public static long[] randomLong(int size) {
        long[] numbers = new long[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i;
        }
        return numbers;
    }
}
