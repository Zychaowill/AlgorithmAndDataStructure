package com.buildupchao.algorithm.leetcode.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author buildupchao
 * @date 2020/06/08 15:52
 * @since JDK 1.8
 */
public class TwoSumApp {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (cache.containsKey(complement)) {
                return new int[] { cache.get(complement), i };
            }
            cache.put(nums[i], i);
        }
        throw  new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSumApp twoSumApp = new TwoSumApp();
        int[] nums = { 2, 7, 11, 15 };
        int target = 18;
        int[] results = twoSumApp.twoSum(nums, target);

        for (int res : results) {
            System.out.println(res + " : " + nums[res]);
        }
    }
}
