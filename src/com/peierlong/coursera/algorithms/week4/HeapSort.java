package com.peierlong.coursera.algorithms.week4;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author elong
 * @version V1.0
 * @date 2017/12/26
 */
public class HeapSort {

    public static void sort(Comparable[] pq) {
        int n = pq.length;
        for (int i = n / 2; i >= 1; i--) {
            sink(pq, i, n);
        }
        while (n > 1) {
            exch(pq, 1, n);
            sink(pq, 1, --n);
        }
    }

    /**
     * 堆元素下沉
     */
    private static void sink(Comparable[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1)) {
                j++;
            }
            if (!less(pq, k, j)) {
                break;
            }
            exch(pq, j, k);
            k = j;
        }
    }

    /**
     * 判断pq[i]是否小于pq[j]
     */
    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }

    /**
     * 替换方法
     */
    private static void exch(Comparable[] pq, int i, int j) {
        Comparable swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }

    public static void main(String[] args) {
        Integer[] a = {4, 4, 4, 4, 4, 4, 4, 4, 3, 5, 6, 9, 19, 23, 54, 75, 1, 88, 44, 45, 54, 78, 12, 14, 15, 16, 11, 991, 765, 28, 29, 49, 81, 80};
        HeapSort.sort(a);
        for (Integer i : a) {
            StdOut.print(i + " ");
        }
    }

}
