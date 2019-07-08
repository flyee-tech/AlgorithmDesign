package com.peierlong.coursera.algorithms.week3;

import com.peierlong.coursera.algorithms.week2.Shuffle;

import static com.peierlong.utils.Util.less;
import static com.peierlong.utils.Util.swap;

/**
 * @author elong
 * @version V1.0
 * @date 2017/12/22
 */
public class QuickSort {

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
        while (true) {
            while (less(a[++i], a[lo])) {
                if (i == hi) {
                    break;
                }
            }
            while (less(a[lo], a[--j])) {
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

    private static int partition1(Comparable[] a, int lo, int hi) {
        Comparable pivot = a[hi];
        int i = lo;
        for (int j = lo; j <= hi - 1; j++) {
            if (less(a[j], pivot)) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, hi);
        return i;
    }

}
