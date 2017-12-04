package com.peierlong.coursera.algorithms.week1.homework;

import edu.princeton.cs.algs4.StdOut;

/**
 * 3-SUM in quadratic time.
 * Design an algorithm for the 3-SUM problem that takes time
 * proportional to n2 in the worst case. You may assume that
 * you can sort the n integers in time proportional to n2 or better.
 *
 * @author elong
 * @version V1.0
 * @date 04/12/2017
 */
public class ThreeSum {

    public static int threeSumProblem(int[] a) {
        int cnt = 0;
        for (int i = 0; i < a.length - 2; i++) {
            int j = i + 1;
            int k = a.length - 1;
            while (j < k) {
                int sum = a[i] + a[j] + a[k];
                if (sum == 0) {
                    cnt++;
                }
                if (sum >= 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {-40, -30, -20, -10, 0, 5, 10, 40};
        int cnt = threeSumProblem(a);
        StdOut.println(cnt);
    }

}
