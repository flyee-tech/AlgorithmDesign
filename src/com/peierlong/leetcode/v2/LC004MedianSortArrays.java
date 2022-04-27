package com.peierlong.leetcode.v2;

public class LC004MedianSortArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int lenX = nums1.length;
        int lenY = nums2.length;

        int lo = 0;
        int hi = lenX;

        while (lo <= hi) {
            int px = (lo + hi) / 2;
            int py = (lenX + lenY + 1) / 2 - px;

            int maxLeftX = px == 0 ? Integer.MIN_VALUE : nums1[px - 1];
            int maxRightX = px == lenX ? Integer.MAX_VALUE : nums1[px];

            int maxLeftY = py == 0 ? Integer.MIN_VALUE : nums2[py - 1];
            int maxRightY = py == lenY ? Integer.MAX_VALUE : nums2[py];

            if (maxLeftX <= maxRightY && maxLeftY <= maxRightX) {
                if ((lenX + lenY) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(maxRightX, maxRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            }

            if (maxLeftX >= maxRightY) {
                hi = px - 1;
            } else {
                lo = px + 1;
            }
        }
        throw new IllegalArgumentException();
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6, 7, 9};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
