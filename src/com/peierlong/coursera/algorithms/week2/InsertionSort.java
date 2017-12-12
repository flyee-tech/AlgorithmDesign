package com.peierlong.coursera.algorithms.week2;

import edu.princeton.cs.algs4.StdOut;

import static com.peierlong.utils.Util.*;

/**
 * 插入排序的实现
 *
 * @author elong
 * @version V1.0
 * @date 2017/12/12
 */
public class InsertionSort {

    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    swap(a, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {6, 5, 7, 8, 10, 1, 100, 23, 76, 19, 11};
        sort(a);
        for (Integer integer : a) {
            StdOut.print(integer + " ");
        }
    }

}
