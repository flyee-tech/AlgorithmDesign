package com.peierlong.coursera.algorithms.week1.homework;

import edu.princeton.cs.algs4.StdOut;

/**
 * 给定一个双调数组（是一个先递增后递减的数组），
 * 其中有 n 个不同的整型值，确定给定的整数是否
 * 存在于数组。
 * 时间复杂度 ~3lgN
 *
 * @author elong
 * @version V1.0
 * @date 04/12/2017
 */
public class SimpleBitonicArraySearch {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 10, 29, 28, 27, 23, 22, 19, 17};
        int result = find(a, 6);
        StdOut.println(result);
    }

    public static int find(int[] a, int key) {
        int maxIdx = findTheMaxIdx(a);
        if (key == a[maxIdx]) {
            return maxIdx;
        }
        int first = findFirst(a, maxIdx, key);
        if (first != -1) {
            return first;
        }
        return findLast(a, maxIdx, key);
    }

    /**
     * Use the binary search find max value
     * ~lgN
     */
    public static int findTheMaxIdx(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] > a[mid + 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    /**
     * Use the binary search find the increasing sequence
     * ~lgN
     */
    private static int findFirst(int[] a, int maxIdx, int key) {
        int loIdx = 0;
        int hiIdx = maxIdx;
        while (loIdx <= hiIdx) {
            int mid = (loIdx + hiIdx) / 2;
            if (a[mid] > key) {
                hiIdx = mid - 1;
            } else if (a[mid] < key) {
                loIdx = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Use the binary search find the decreasing sequence
     * ~lgN
     */
    private static int findLast(int[] a, int maxIdx, int key) {
        int loIdx = maxIdx;
        int hiIdx = a.length - 1;
        while (loIdx <= hiIdx) {
            int mid = (loIdx + hiIdx) / 2;
            if (a[mid] < key) {
                hiIdx = mid - 1;
            } else if (a[mid] > key) {
                loIdx = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
