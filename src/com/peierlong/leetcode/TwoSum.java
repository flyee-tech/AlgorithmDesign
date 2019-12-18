package com.peierlong.leetcode;

import java.util.Arrays;

/**
 * @author Peiel
 * @version V1.0
 * @date 2019/12/18
 */
public class TwoSum {

    //leetcode score
    //29 / 29 test cases passed.
    //Runtime: 19 ms
    //Memory Usage: 36.7 MB
    public static int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum1(nums, 9);
//        System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        System.out.println(Arrays.toString(result));
    }

}
