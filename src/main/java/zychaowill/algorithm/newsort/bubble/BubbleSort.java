package zychaowill.algorithm.newsort.bubble;

import zychaowill.algorithm.newsort.util.ArrayUtil;

/**
 * Created by yachao on 17/11/25.
 */
public class BubbleSort<T> {

    private boolean showStage = false;

    public <T extends Comparable<T>> void sort(T[] values, boolean showStage) {
        this.showStage = showStage;
        executeSort(values, 0, values.length - 1);
    }

    private <T extends Comparable<T>> void executeSort(T[] values, int startIndex, int endIndex) {
        int outer = endIndex;
        int inner = startIndex;

        T temp;
        for (outer = endIndex; outer > 1; outer--) {
            for (inner = startIndex; inner < outer; inner++) {
                if (values[inner].compareTo(values[outer]) > 0) {
                      temp = values[inner];
                      values[inner] = values[outer];
                      values[outer] = temp;
                }
            }
            if (showStage) {
                System.out.print(outer + ": ");
                ArrayUtil.displayArray(values);
            }
        }
    }
}
