package com.peierlong.coursera.algorithms.week1.union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * 快速合并算法
 * BY: elong
 * ON: 31/10/2017
 */
public class QuickUnionUF {

    private List<Integer> list = new ArrayList<>();
    private int count;

    public QuickUnionUF(Integer N) {
        count = N;
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
    }

    public int count() {
        return count;
    }

    private void validate(int p) {
        int n = list.size();
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    private int root(int p) {
        while (p != list.get(p)) {
            p = list.get(p);
        }
        return p;
    }

    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) return;
        list.set(rootP, rootQ);
        count--;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) throws Exception {
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println("union " + p + " " + q);
            }
            StdOut.println(uf.toString());
            StdOut.println(uf.count() + " components");
        }
    }
}
