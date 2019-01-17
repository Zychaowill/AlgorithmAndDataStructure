package com.buildupchao.algorithm.newsort.insert.example;

import com.buildupchao.algorithm.newsort.insert.NewInserSort;
import com.buildupchao.algorithm.newsort.util.ArrayUtil;

/**
 * Created by yachao on 17/11/25.
 */
public class NewInsertSortExample {

    public static void main(String[] args) {
        Integer[] values = ArrayUtil.generateArray(10);
        new NewInserSort().sort(values, false);

        ArrayUtil.displayArray(values);
    }
}
