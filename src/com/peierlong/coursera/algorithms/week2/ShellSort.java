package com.peierlong.coursera.algorithms.week2;

import edu.princeton.cs.algs4.StdOut;

import static com.peierlong.utils.Util.less;
import static com.peierlong.utils.Util.swap;

/**
 * 希尔排序的实现
 *
 * @author elong
 * @version V1.0
 * @date 2017/12/12
 */
public class ShellSort {


    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        for (; h < N / 3; ) {
            h = 3 * h + 1;
        }
        for (; h >= 1; ) {
            for (int i = h; i < N; i++) {
                for (int j = i; j - h >= 0; j -= h) {
                    if (less(a[j], a[j - h])) {
                        swap(a, j, j - h);
                    } else {
                        break;
                    }
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {6, 5, 7, 8, 10, 1, 100, 23, 76, 19, 11, 22, 18, 90, 21, 87, 78, 91, 68, 56, 57, 53, 38};
        sort(a);
        for (Integer integer : a) {
            StdOut.print(integer + " ");
        }
    }

}
