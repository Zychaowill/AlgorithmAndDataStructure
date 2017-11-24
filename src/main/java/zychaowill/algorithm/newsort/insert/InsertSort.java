package zychaowill.algorithm.newsort.insert;

import java.util.Arrays;

/**
 * Created by yachao on 17/10/20.
 */
public class InsertSort {

    public void sort(int[] a) {
        int j;
        for (int i = 1; i < a.length; i++) {
            int t = a[i];
            for (j = i; j > 0 && a[j - 1] > t; j--) {
                a[j] = a[j - 1];
            }
            a[j] = t;
        }

        Arrays.stream(a).forEach(elem -> {
            System.out.print(elem + "\t");
        });
    }

    public static void main(String[] args) {
        int[] a = new int[]{8, 3, 2, 1, 7, 4, 6, 5};
        new InsertSort().sort(a);
    }
}
