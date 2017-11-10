package com.peierlong.coursera.algorithms.week2.homework;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author elong
 * @version V1.0
 * @date 10/11/2017
 */
public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        while (StdIn.hasNextChar()) {
            queue.enqueue(StdIn.readString());
        }
        if (args.length > 0 && args[0] != null) {
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                StdOut.println(queue.sample());
            }
        }
    }
}
