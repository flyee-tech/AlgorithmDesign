package com.peierlong.leetcode;

import java.util.Arrays;

/**
 * @author Peiel
 * @version V1.0
 * @date 2019/12/30
 */
public class FindMedianSortedArrays {

    /*
    leetcode out:
        Runtime: 15 ms, faster than 8.78% of Java online submissions for Median of Two Sorted Arrays.
        Memory Usage: 46.3 MB, less than 91.67% of Java online submissions for Median of Two Sorted Arrays.
    time complexity:
        O(m+n)
     */
    public static double solution1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 顺序合并两个数组
        int[] merge = new int[len1 + len2];
        int i = 0, j = 0, z = 0;
        while (i < len1 || j < len2) {
            if (i < len1 && j >= len2) {
                merge[z++] = nums1[i++];
                continue;
            }
            if (i >= len1) {
                merge[z++] = nums2[j++];
                continue;
            }
            if (nums1[i] < nums2[j]) {
                merge[z++] = nums1[i++];
            } else {
                merge[z++] = nums2[j++];
            }
        }

        System.out.println(Arrays.toString(merge));

        // 执行公式计算中位数
        int len3 = merge.length;
        if (len3 % 2 == 0) {
            return (merge[len3 / 2 - 1] + merge[len3 / 2]) / 2d;
        } else {
            return merge[len3 / 2];
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};


        double d = solution1(nums1, nums2);
        System.out.println(d);

    }

}
