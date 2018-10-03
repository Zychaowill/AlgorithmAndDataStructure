package zychaowill.algorithm.classical;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import zychaowill.algorithm.classical.util.NumberFactory;

/**
 * Created by yachao on 2018/6/18.
 */
public class FindRepeatElement {

    public static void main(String[] args) {
        int[] array = intArray(101);
        array[array.length - 1] = getRepeatElement();
        
        array = shuffle(array);
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
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    
    private static int getRepeatElement() {
        Random random = new Random();
        int element = random.nextInt(100);
        System.out.printf("Getting repeat element is %d.\n", element);
        return element;
    }
    
    private static int[] intArray(int size) {
    	int[] array = new int[size];
        System.arraycopy(NumberFactory.randomInt(size - 1), 0, array, 0, 0 + array.length - 1);
        return array;
    }
    
    private static int[] shuffle(int[] array) {
    	List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
    	Integer last = list.remove(list.size() - 1);
    	Collections.shuffle(list);
    	list.add(last);
    	return list.stream().mapToInt(x -> x).toArray();
    }
}
