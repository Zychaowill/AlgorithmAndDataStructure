package zychaowill.algorithm.classical;

import zychaowill.algorithm.classical.util.NumberFactory;

/**
 * Created by yachao on 2018/6/18.
 */
public class FindRepeatElement {

    public static void main(String[] args) {
        int[] array = new int[101];
        System.arraycopy(NumberFactory.randomInt(100), 0, array, 0, 100);

        print(array);
        int sum = sum(array);
        for (int i = 0; i < array.length - 1; i++) {
            sum -= array[i];
        }

        System.out.printf("The repeat element is %d.\n", sum);
    }

    private static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
            if (i % 10 == 0) {
                System.out.println();
                break;
            }
        }
        System.out.println();
    }
}
