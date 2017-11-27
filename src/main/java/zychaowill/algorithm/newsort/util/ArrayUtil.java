package zychaowill.algorithm.newsort.util;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * Created by yachao on 17/11/25.
 */
public class ArrayUtil<T> {

    public static <T extends Comparable<T>> void displayArray(T[] values) {
        Arrays.stream(values).forEach(value -> System.out.print(value + " "));
        System.out.println();
    }

    public static Integer[] generateArray(int size) {
        Random rand = new Random();
        Integer[] values = new Integer[size];

        Integer value = null;
        for (int i = 0; i < size; i++) {
            value = rand.nextInt(100);
            if (!contains(values, value, i)) {
                values[i] = value;
            } else {
                i -= 1;
            }
        }
        return values;
    }

    private static <T extends Comparable<T>> boolean contains(T[] values, T key, int endIndex) {
        if (Objects.isNull(values) || Objects.isNull(key) || endIndex == 0) {
            return false;
        }
        for (int i = 0; i < endIndex; i++) {
            if (values[i].compareTo(key) == 0) {
                return true;
            }
        }
        return false;
    }
}
