package com.peierlong.coursera.algorithms.week1.homework;

/**
 * @author elong
 * @version V1.0
 * @date 05/12/2017
 */
public class FastBitonicArraySearch {
    static int[] a = {29, 28, 27, 23, 22, 19, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7};

    public static boolean left_search(int key, int lo, int hi) {
        // Invariant: a[lo] <= key < a[hi]
        while (lo < hi - 1) {
            int mid = (lo + hi) / 2;
            if (key < a[mid]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return (key == a[lo]);
    }

    public static boolean right_search(int key, int lo, int hi) {
        // Invariant: a[lo] > key >= a[hi]
        while (lo < hi - 1) {
            int mid = (lo + hi) / 2;
            if (key < a[mid]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return (key == a[hi]);
    }

    public static boolean bitonic_search(int key) {
        int lo = 0, hi = a.length - 1;
        // Invariants: a is bitonic from lo..hi,
        //             key >= a[lo]. and
        //             key >= a[hi]
        while (lo < hi - 1) {
            int mid = (lo + hi) / 2;
            if (key < a[mid]) {
                return left_search(key, lo, mid) ||
                        right_search(key, mid, hi);
            } else {
                if (a[mid] < a[mid + 1]) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }
        return (key == a[lo]) || (key == a[hi]);
    }

    public static void main(String[] args) {
        boolean b = bitonic_search(14);
        System.out.println(b);

    }
}
