package com.peierlong.utils;

/**
 * @author elong
 * @version V1.0
 * @date 2017/12/12
 */
public class Util {

    public static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

}
