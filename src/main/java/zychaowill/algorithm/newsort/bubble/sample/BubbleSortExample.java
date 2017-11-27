package zychaowill.algorithm.newsort.bubble.sample;

import zychaowill.algorithm.newsort.bubble.BubbleSort;
import zychaowill.algorithm.newsort.util.ArrayUtil;

/**
 * Created by yachao on 17/11/25.
 */
public class BubbleSortExample {

    public static void main(String[] args) {
        Integer[] values = ArrayUtil.generateArray(10);

        new BubbleSort<Integer>().sort(values, false);

        ArrayUtil.displayArray(values);
    }
}
