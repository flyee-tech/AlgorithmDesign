package com.peierlong.coursera.algorithms.week1.union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 并查集 - 快速查找
 * <p>
 * BY: elong
 * ON: 31/10/2017
 */
public class QuickFindUF {

    private List<Integer> list = new ArrayList<>();
    private int count;

    public QuickFindUF(Integer N) {
        count = N;
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
    }

    public int count() {
        return count;
    }

    public int find(int idxP) {
        return list.get(idxP);
    }

    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return Objects.equals(list.get(p), list.get(q));
    }

    public void union(int p, int q) {
        int valP = list.get(p);
        int valQ = list.get(q);
        if (valP == valQ) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == valP) {
                list.set(i, valQ);
            }
        }
        count--;
    }

    private void validate(int p) {
        int n = list.size();
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) throws Exception {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }
            StdOut.println(uf.toString());
            StdOut.println(uf.count() + " components");
        }
    }


}
