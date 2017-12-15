package com.peierlong.coursera.algorithms.week3;

import edu.princeton.cs.algs4.StdOut;

/**
 * 自下而上的归并排序
 *
 * @author elong
 * @version V1.0
 * @date 2017/12/15
 */
public class BUMergeSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz *= 2) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                MergeSort.merge(a, aux, lo, (lo + lo + sz + sz - 1) / 2, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {4, 3, 5, 6, 9, 19, 23, 54, 75, 1, 88, 44, 45, 54, 78, 12, 14, 15, 16, 11, 991, 765, 28, 29, 49, 81, 80};
        BUMergeSort.sort(a);
        for (Integer i : a) {
            StdOut.print(i + " ");
        }
    }

}
