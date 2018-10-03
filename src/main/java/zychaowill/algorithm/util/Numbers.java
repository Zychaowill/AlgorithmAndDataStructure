package zychaowill.algorithm.util;

import java.util.Random;
import java.util.stream.IntStream;

public class Numbers {
	
	public static int[] integers() {
		return integers(10);
	}
	
	public static int[] integers(int size) {
		int[] numbers = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			numbers[i] = random.nextInt(1000);
		}
		return numbers;
	}
	
	public static long[] longs() {
		return longs(10);
	}
	
	public static long[] longs(int size) {
		long[] numbers = new long[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			numbers[i] = random.nextLong();
		}
		return numbers;
	}
	
	public static int[] serials() {
		return serials(10);
	}
	
	public static int[] serials(int size) {
		return IntStream.rangeClosed(0, size).toArray();
	}
}
