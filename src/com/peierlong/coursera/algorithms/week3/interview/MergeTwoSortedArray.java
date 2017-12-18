package com.peierlong.coursera.algorithms.week3.interview;

import edu.princeton.cs.algs4.StdOut;

import static com.peierlong.utils.Util.less;
import static com.peierlong.utils.Util.swap;

/**
 * 合并两个有序数组（0 ~ n-1) (n-1 ~ n*2-1），要求辅助数组只能用长度为 N 的数组
 *
 * @author elong
 * @version V1.0
 * @date 2017/12/18
 */
public class MergeTwoSortedArray {
    private static int auxLength = 0;

    public static void sort(Comparable[] a) {
        int N = a.length / 2;
        int _2N = a.length;
        if (!less(a[N], a[N - 1])) {
            return;
        }
        if (!less(a[0], a[_2N - 1])) {
            for (int i = 0; i < N; i++) {
                swap(a, i, N + i);
            }
            return;
        }

        Comparable[] aux = new Comparable[N];
        for (int i = N - 1; i >= 0; i--) {
            if (!less(a[N], a[i])) {
                copyToAux(a, aux, i + 1, N);
                mergeSort(a, aux, 0, N, i + 1);
                return;
            }
        }

    }

    private static void copyToAux(Comparable[] a, Comparable[] aux, int start, int end) {
        for (int i = start, j = 0; i < end; i++) {
            aux[j++] = a[i];
            auxLength++;
        }
    }

    private static void mergeSort(Comparable[] a, Comparable[] aux, int i, int j, int k) {
        while (k < a.length) {
            if (i > auxLength - 1) {
                a[k++] = a[j++];
            } else if (j > a.length - 1) {
                a[k++] = aux[i++];
            } else if (less(a[j], aux[i])) {
                a[k++] = a[j++];
            } else {
                a[k++] = aux[i++];
            }
        }
    }


    public static void main(String[] args) {
        Integer[] a = {10, 11, 12, 13, 5, 6, 7, 8};

        MergeTwoSortedArray.sort(a);

        for (Integer integer : a) {
            StdOut.print(integer + " ");
        }
    }

}
