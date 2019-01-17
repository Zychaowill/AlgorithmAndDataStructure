package com.buildupchao.algorithm.newsort.select;

import com.buildupchao.algorithm.newsort.util.ArrayUtil;

/**
 * Created by yachao on 17/11/25.
 */
public class SelectSort {

    private boolean showStage = false;

    public <T extends Comparable<T>> void sort(T[] values, boolean showStage) {
        this.showStage = showStage;
        executeSort(values, 0 , values.length - 1);
    }

    private <T extends Comparable<T>> void executeSort(T[] values, int startIndex, int endIndex) {

        int i, j;
        int minIndex;
        T temp;
        for (i = 0; i <= endIndex; i++) {
            minIndex = i;
            for (j = i + 1; j <= endIndex; j++) {
                if (values[j].compareTo(values[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            temp = values[i];
            values[i] = values[minIndex];
            values[minIndex] = temp;

            if (showStage) {
                System.out.print(i + ": ");
                ArrayUtil.displayArray(values);
            }
        }

    }
}
