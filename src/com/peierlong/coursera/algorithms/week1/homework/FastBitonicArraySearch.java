package com.peierlong.coursera.algorithms.week1.homework;

/**
 * @author elong
 * @version V1.0
 * @date 05/12/2017
 */
public class FastBitonicArraySearch {

    private static boolean leftSearch(int[] a, int key, int lo, int hi) {
        while (lo < hi - 1) {
            int mid = (lo + hi) / 2;
            if (key < a[mid]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return key == a[lo];
    }

    private static boolean rightSearch(int[] a, int key, int lo, int hi) {
        while (lo < hi - 1) {
            int mid = (lo + hi) / 2;
            if (key < a[mid]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return key == a[hi];
    }

    public static boolean bitonicSearch(int[] a, int key) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi - 1) {
            int mid = (lo + hi) / 2;
            if (key < a[mid]) {
                return leftSearch(a, key, lo, mid) || rightSearch(a, key, mid, hi);
            } else {
                if (a[mid] < a[mid + 1]) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }
        return key == a[lo] || key == a[hi];
    }

    /**
     * Test OutPut:
     * 1 is in array? true
     * 2 is in array? true
     * 3 is in array? true
     * 4 is in array? true
     * 5 is in array? true
     * 6 is in array? true
     * 29 is in array? true
     * 28 is in array? true
     * 27 is in array? true
     * 23 is in array? true
     * 22 is in array? true
     * 19 is in array? true
     * 17 is in array? true
     * 16 is in array? true
     * 15 is in array? true
     * 14 is in array? true
     * 13 is in array? true
     * 12 is in array? true
     * 11 is in array? true
     * 10 is in array? true
     * 9 is in array? true
     * 8 is in array? true
     * 7 is in array? true
     * 1000 is in array? false
     * 0 is in array? false
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 29, 28, 27, 23, 22, 19, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7};
        for (int i : a) {
            boolean b = bitonicSearch(a, i);
            System.out.println(i + " is in array? " + b);
        }
        System.out.println("1000 is in array? " + bitonicSearch(a, 1000));
        System.out.println("0 is in array? " + bitonicSearch(a, 0));
    }
}
