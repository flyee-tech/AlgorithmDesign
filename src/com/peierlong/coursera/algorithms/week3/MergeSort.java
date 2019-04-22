package com.peierlong.coursera.algorithms.week3;

import com.peierlong.coursera.algorithms.week2.InsertionSort;
import edu.princeton.cs.algs4.StdOut;

import static com.peierlong.utils.Util.less;

/**
 * 归并排序的实现
 *
 * @author elong
 * @version V1.0
 * @date 2017/12/14
 */
public class MergeSort {

    /*
     * 使用插入排序阀值(参考自 JDK Arrays工具类)
     */
    private static final int INSERTIONSORT_THRESHOLD = 7;

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        // 优化一：如果元素个数比较小的时候，使用插入排序可以提高性能。
        if ((hi - lo) < INSERTIONSORT_THRESHOLD) {
            InsertionSort.sort(a, lo, hi);
        }
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        // 优化二：如果前半部分的最后一个数的值小于后半部分的第一个值，那么跳过不进行比较
        if (less(a[mid], a[mid + 1])) {
            return;
        }
        merge(a, aux, lo, mid, hi);
    }

    public  static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (j > hi) {
                a[k] = aux[i++];
            } else if (i > mid || less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {4, 3, 5, 6, 9, 19, 23, 54, 75, 1, 88, 44, 45, 54, 78, 12, 14, 15, 16, 11, 991, 765, 28, 29, 49, 81, 80};
        MergeSort.sort(a);
        for (Integer i : a) {
            StdOut.print(i + " ");
        }
    }

}






