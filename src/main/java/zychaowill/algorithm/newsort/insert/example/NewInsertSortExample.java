package zychaowill.algorithm.newsort.insert.example;

import zychaowill.algorithm.newsort.insert.NewInserSort;
import zychaowill.algorithm.newsort.util.ArrayUtil;

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
