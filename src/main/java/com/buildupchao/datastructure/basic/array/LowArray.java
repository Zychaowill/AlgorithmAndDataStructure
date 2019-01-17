package com.buildupchao.datastructure.basic.array;

import com.buildupchao.datastructure.basic.exception.ArrayException;

/**
 * Created by yachao on 17/11/25.
 */
public class LowArray {

    private long[] values;
    private int size;

    public LowArray(int size) {
        this.size = size;
        values = new long[size];
    }

    public void setElement(int index, long value) {
        if (!checkArrayIndex(index)) {
            throw new ArrayException("Index out of bound exception!");
        }
        values[index] = value;
    }

    public long getElement(int index) {
        if (!checkArrayIndex(index)) {
            throw new ArrayException("Index out of bound exception!");
        }
        return values[index];
    }

    private boolean checkArrayIndex(int index) {
        if (index < 0 || index > size) {
            return false;
        }
        return true;
    }
}
