package com.peierlong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Peiel
 * @version V1.0
 * @date 2019/12/18
 */
public class TwoSum {

    /*
    leetcode score:
    29 / 29 test cases passed.
    Runtime: 19 ms
    Memory Usage: 36.7 MB

    complexity analysis:
    time complexity: O(n²)
    space complexity: O(1)
    */
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

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (map.containsKey(n) && i != map.get(n)) {
                return new int[]{i, map.get(n)};
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }

    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (map.containsKey(n)) {
                return new int[]{map.get(n), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum3(nums, 9);
//        System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        System.out.println(Arrays.toString(result));
    }

}
