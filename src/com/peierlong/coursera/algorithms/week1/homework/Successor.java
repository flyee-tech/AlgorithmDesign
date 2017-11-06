package com.peierlong.coursera.algorithms.week1.homework;

import edu.princeton.cs.algs4.StdOut;

/**
 * BY: elong
 * ON: 03/11/2017
 */
public class Successor {

    private int[] S;
    private boolean[] isRemove;

    Successor(int N) {
        isRemove = new boolean[N];
        S = new int[N];
        for (int i = 0; i < N; i++) {
            isRemove[i] = false;
            S[i] = i;
        }
    }

    public void remove(int p) {
        isRemove[p] = true;
    }

    public int getSuccessor(int p) {
        if (p >= S.length - 1) {
            return -1;
        }
        while (isRemove[p + 1]) {
            p++;
        }
        return S[p + 1];
    }

    public static void main(String[] args) {
        Successor successor = new Successor(10);
        successor.remove(2);
        successor.remove(4);
        successor.remove(3);
        StdOut.println("the successor is : " + successor.getSuccessor(3));
        successor.remove(7);
        successor.remove(9);
        StdOut.println("the successor is : " + successor.getSuccessor(7));
    }

}
