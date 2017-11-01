package com.peierlong.base.union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * 加权并查集的实现
 * 路径压缩算法 + 加权算法
 * 并查集实现
 *
 * BY: elong
 * ON: 01/11/2017
 */
public class WeightedQuickUnionUF {

    private List<Integer> list = new ArrayList<>();
    private List<Integer> size = new ArrayList<>();
    private int count;

    WeightedQuickUnionUF(Integer N){
        count = N;
        for (int i =0; i< N;i++) {
            list.add(i);
            size.add(1);
        }
    }

    public int count() {
        return count;
    }

    public int root(int p) {
        validate(p);
        while (p != list.get(p)) {
            list.set(p, list.get(list.get(p)));    //路径压缩算法
            p = list.get(p);
        }
        return p;
    }

    public void validate(int p) {
        if (p < 0 || p >= list.size()) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (list.size() - 1));
        }
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
        if (size.get(rootP) >= size.get(rootQ)) {    //加权算法
            list.set(rootQ, rootP);
            size.set(rootP, size.get(rootP) + size.get(rootQ));
        }
        if (size.get(rootP) < size.get(rootQ)) {
            list.set(rootP, rootQ);
            size.set(rootQ, size.get(rootQ) + size.get(rootP));
        }
        count--;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) throws Exception {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
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
