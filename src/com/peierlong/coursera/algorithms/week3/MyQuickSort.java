package com.peierlong.coursera.algorithms.week3;

import com.peierlong.coursera.algorithms.week2.Shuffle;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import static com.peierlong.utils.Util.less;
import static com.peierlong.utils.Util.swap;

/**
 * @author elong
 * @version V1.0
 * @date 2017/12/22
 */
public class MyQuickSort {


    public static void sort(Comparable[] a) {
        Shuffle.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }


    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            // 处理左指针
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] a = {4, 4, 4, 4, 4, 4, 4, 4, 3, 5, 6, 9, 19, 23, 54, 75, 1, 88, 44, 45, 54, 78, 12, 14, 15, 16, 11, 991, 765, 28, 29, 49, 81, 80};
//        Integer[] a = new Integer[1000000];
//        for (int i = 0; i < 1000000; i++) {
//            a[i] = i;
//        }
        Stopwatch stopwatch = new Stopwatch();
        MyQuickSort.sort(a);
        for (Integer i : a) {
            StdOut.print(i + " ");
        }
        StdOut.println();
        StdOut.println(stopwatch.elapsedTime());
    }

}
