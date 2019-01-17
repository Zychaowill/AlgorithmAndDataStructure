package com.buildupchao.datastructure.basic.array;

import java.util.Arrays;

/**
 * Created by yachao on 17/11/25.
 */
public class HighArray {

    private long[] values;
    private int length;

    public HighArray(int size) {
        values = new long[size];
        length = 0;
    }

    public boolean contains(long key) {
        int low = 0, high = length;

        int middle;
        while (low < high) {
            middle = (low + high) / 2;
            if (values[middle] > key) {
                high = middle - 1;
            } else if (values[middle] < key) {
                low = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public void insert(long value) {
        values[length++] = value;
    }

    public boolean delete(long value) {
        if (!contains(value)) {
            return false;
        }

        int i;
        for (i = 0; i < length; i++) {
            if (values[i] == value) {
                break;
            }
        }
        if (i != length) {
            for (int j = i; j < length - 1; j++) {
                values[j] = values[j + 1];
            }
            length -= 1;
            return true;
        }
        return false;
    }

    public void display() {
        Arrays.stream(values).forEach(value -> System.out.print(value + " "));
        System.out.println();
    }
}
