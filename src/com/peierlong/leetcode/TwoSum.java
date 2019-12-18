package com.peierlong.leetcode;

import java.util.Arrays;

/**
 * @author Peiel
 * @version V1.0
 * @date 2019/12/18
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum(nums, 9);
        Arrays.stream(result).forEach(System.out::print);
    }

}
