package zychaowill.algorithm.dynamic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * dp(0) = 0; dp(1) = 1; dp(3) = 1; dp(5) = 1;
 * 
 * dp(k) = min{dp(k-vi)} + 1, k - vi >= 0, vi表示第i个硬币的面值
 * 
 * k % m = k & (m - 1), m = 2^n
 */
public class MinNumberOfCoinProblem {
	
	private HashSet<Integer> coins;
	
	public MinNumberOfCoinProblem(int[] coins) {
		super();
		this.coins = Arrays.stream(coins).boxed().collect(Collectors.toCollection(HashSet::new));
	}

	public int dp(int k) {
		return dpmin(k);
	}
	
	private int dpmin(int k) {
		if (k == 0)
			return 0;
		else if(onlyOne(k))
			return 1;
		
		int min = k / 1;
		for (int coin : coins) {
			if (k >= coin) {
				int divide = k / coin;
				int mode = k % coin;
				int numberOfCoin = divide + dpmin(mode);
				if (numberOfCoin < min) {
					min = numberOfCoin;
				}
			}
		}
		return min;
	}
	
	private boolean onlyOne(int money) {
		return coins.contains(money);
	}
	
	public static void main(String[] args) {
		int[] coins = { 1, 3, 5 };
		MinNumberOfCoinProblem minNumberOfCoinProblem = new MinNumberOfCoinProblem(coins);
		
		IntStream.rangeClosed(0, 11).forEach(x -> {
			int numberOfCoins = minNumberOfCoinProblem.dp(x);
			System.out.printf("The number of coins for money %d is %d\n", x, numberOfCoins);
		});
	}
}
