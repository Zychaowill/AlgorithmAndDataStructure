package com.buildupchao.algorithm.newsort.insert;

/**
 * Created by yachao on 17/11/25.
 */
public class NewInserSort {

    private boolean showStage = false;

    public <T extends Comparable<T>> void sort(T[] values, boolean showStage) {
        this.showStage = showStage;
        executeSort(values, 0, values.length - 1);
    }

    private <T extends Comparable<T>> void executeSort(T[] values, int startIndex, int endIndex) {
        int i, j;

        T temp;
        for (i = startIndex + 1; i <= endIndex; i++) {
            temp = values[i];
            j = i;
            while (j > 0 && values[j - 1].compareTo(temp) >= 0) {
                values[j] = values[j - 1];
                j -= 1;
            }
            values[i] = temp;
        }
    }
}
