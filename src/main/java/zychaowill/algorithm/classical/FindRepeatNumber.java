package zychaowill.algorithm.classical;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import zychaowill.algorithm.classical.util.FindRepeatElementUtils;
import zychaowill.algorithm.classical.util.NumberFactory;

public class FindRepeatNumber {
	
	public static void main(String[] args) {
		int[] array = intArrayAndShuffle(100);
		print(array);
		
		long startTime = System.nanoTime();
		int target = /*findRepeatNum(array);*/ FindRepeatElementUtils.findRepeatNum(array);
		System.out.printf("The repeat element is %d, cost %d.\n", target, (System.nanoTime() - startTime));
	}
	
/*	private static int findRepeatNum(int[] array) {
		int result = 0;
		byte[] mark = new byte[15000];
		for (int el : array) {
			int j = el / 8;
			int k = el % 8;
			int check = 1 << k;
			if ((mark[j] & check) != 0) {
				result = mark[j];
				break;
			}
			mark[j] |= check;
		}
		return result;
	}*/
	
    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    
    private static int[] intArrayAndShuffle(int size) {
    	int[] array = new int[size];
        System.arraycopy(NumberFactory.randomInt(size - 1), 0, array, 0, 0 + array.length - 1);
        array[array.length - 1] = getRepeatElement();
        return shuffle(array);
    }
    
    private static int getRepeatElement() {
        Random random = new Random();
        int element = random.nextInt(100);
        System.out.printf("Getting repeat element is %d.\n", element);
        return element;
    }
    
    private static int[] shuffle(int[] array) {
    	List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
    	Collections.shuffle(list);
    	return list.stream().mapToInt(x -> x).toArray();
    }
}
