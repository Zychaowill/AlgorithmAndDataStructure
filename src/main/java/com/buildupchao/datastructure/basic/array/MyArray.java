package com.buildupchao.datastructure.basic.array;

/**
 * @author buildupchao
 * @date 2019/10/12 23:42
 * @since JDK 1.8
 */
public class MyArray {

    private int[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    public void insert(int element, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组的实际元素范围");
        }
        //r如果实际元素达到数组容量上限，则对数组进行扩容
        if (size >= array.length) {
            resize();
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    private void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public int delete(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出数组的实际元素范围");
        }
        int deletedElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deletedElement;
    }

    public void output() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if (i < size) {
                System.out.printf("%d,", array[i]);
            } else {
                System.out.printf("%d", array[i]);
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) throws Exception {
        MyArray array = new MyArray(4);
        array.insert(3, 0);
        array.insert(7, 1);
        array.insert(9, 2);
        array.insert(5, 3);
        array.insert(6, 1);
        array.output();

        array.delete(2);
        array.output();
    }
}
