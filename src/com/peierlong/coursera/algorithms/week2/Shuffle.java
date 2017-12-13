package com.peierlong.coursera.algorithms.week2;

import com.peierlong.utils.Util;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Shuffling 实现
 *
 * @author elong
 * @version V1.0
 * @date 2017/12/13
 */
public class Shuffle {


    public static void shuffle(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int r = StdRandom.uniform(i + 1);
            Util.swap(a, i, r);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        shuffle(a);
        for (Integer anA : a) {
            StdOut.print(anA + " ");
        }
    }

}
