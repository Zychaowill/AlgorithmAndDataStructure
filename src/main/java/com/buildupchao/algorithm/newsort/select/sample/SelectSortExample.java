package com.buildupchao.algorithm.newsort.select.sample;

import com.buildupchao.algorithm.newsort.select.SelectSort;
import com.buildupchao.algorithm.newsort.util.ArrayUtil;

/**
 * Created by yachao on 17/11/25.
 */
public class SelectSortExample {

    public static void main(String[] args) {
        Integer[] values = ArrayUtil.generateArray(10);
        new SelectSort().sort(values, true);

        System.out.println("result: ");
        ArrayUtil.displayArray(values);
    }
}
