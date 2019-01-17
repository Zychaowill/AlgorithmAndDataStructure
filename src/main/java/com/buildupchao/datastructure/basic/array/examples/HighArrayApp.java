package com.buildupchao.datastructure.basic.array.examples;

import com.buildupchao.datastructure.basic.array.HighArray;

/**
 * Created by yachao on 17/11/25.
 */
public class HighArrayApp {

    public static void main(String[] args) {
        HighArray arr;
        arr = new HighArray(10);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        long key = 35;
        if (arr.contains(key)) {
            System.out.println("Found key " + key);
        } else {
            System.out.println("Can't find key " + key);
        }

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();
    }
}
