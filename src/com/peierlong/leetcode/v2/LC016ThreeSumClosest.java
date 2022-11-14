package com.peierlong.leetcode.v2;

import java.util.Arrays;

public class LC016ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        // 初始化 result
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        // 使 nums 有序
        Arrays.sort(nums);
        // 遍历 nums
        for (int i = 0; i < nums.length - 2; i++) {
            // 定义左边的索引和右边的索引
            int l = i + 1, r = nums.length - 1;
            // 让左边的索引和右边的索引向内遍历
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                // 如果 sum 比 target 大，那就 r 向前，反之 l 向后
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
                // 判断 sum 是不是更接近目标值，如果更接近，赋值即可
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LC016ThreeSumClosest().threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
    }

}

