package com.peierlong.coursera.algorithms.week2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import static com.peierlong.utils.Util.less;
import static com.peierlong.utils.Util.swap;

/**
 * 希尔排序的实现 最坏情况下比较次数为N的3/2次方
 *
 * @author elong
 * @version V1.0
 * @date 2017/12/12
 */
public class ShellSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Stopwatch s = new Stopwatch();
        Integer[] a = new Integer[1000000];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(1000000);
        }
        StdOut.println("\n" + s.elapsedTime());
        sort(a);
        for (Integer integer : a) {
            StdOut.print(integer + " ");
        }
        StdOut.println("\n" + s.elapsedTime());
    }

}
