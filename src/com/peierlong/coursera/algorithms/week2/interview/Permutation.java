package com.peierlong.coursera.algorithms.week2.interview;

import com.peierlong.coursera.algorithms.week2.ShellSort;

/**
 * 判断两个非有序的整型数组是否拥有相同个元素个数
 *
 * @author elong
 * @version V1.0
 * @date 2017/12/13
 */
public class Permutation {

    public static boolean isContainTheSameEntries(Integer[] a, Integer[] b) {
        if (a.length != b.length) {
            return false;
        }
        ShellSort.sort(a);
        ShellSort.sort(b);
        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(b[i]) != 0) {
                return false;
            }
        }
        return true;
    }

}
