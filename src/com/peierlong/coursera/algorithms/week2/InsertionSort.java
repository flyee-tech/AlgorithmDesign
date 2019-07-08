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
        int cnt = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                cnt++;
                swap(a, j, j - 1);
            }
        }
        System.out.println(cnt);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
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


    // 插入排序，a 表示数组，n 表示数组大小
    public static void insertionSort(Integer[] a) {
        int n = a.length;
        if (n <= 1) return;
        int cnt = 0;
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    cnt++;
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
        System.out.println(cnt);
    }


}
