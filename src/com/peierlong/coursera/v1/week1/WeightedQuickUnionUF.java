package com.peierlong.coursera.v1.week1;

import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 并查集算法
 * 1. 始终让比较重的树合并到比较轻的树上，这样可以降低树的高度。
 * 2. 在查询root节点的时候，把当前节点指向祖父节点来降低树的高度。
 *
 * @author Peiel
 * @version V1.0
 * @date 2020/1/6
 */
public class WeightedQuickUnionUF implements InterfaceUF {
    private int[] id;
    private int[] size;
    private int count;

    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
        count = N;
    }

    private int root(int i) {
        while (i != id[i]) {
            // 优化一：控制树的高度,把当前节点指向上上个节点。
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    //时间复杂度 logN
    @Override
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) {
            return;
        }
        // 优化二：重量小的向重量大的合并，建立一个数组来记录相应root节点的权重
        if (size[rootP] < size[rootQ]) {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            id[rootQ] = id[rootP];
            size[rootP] += size[rootQ];
        }
        count--;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    //时间复杂度 logN
    @Override
    public int find(int p) {
        return root(p);
    }

    @Override
    public int count() {
        return count;
    }


    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(new File("/Users/peiel/Downloads/largeUF.txt"));
        BufferedReader br = new BufferedReader(fr);

        long start = System.currentTimeMillis();

        InterfaceUF uf = new WeightedQuickUnionUF(Integer.parseInt(br.readLine()));
        String thisLine;
        while ((thisLine = br.readLine()) != null) {
            String[] s = thisLine.split(" ");
            int p = Integer.parseInt(s[0]);
            int q = Integer.parseInt(s[1]);
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");

        long end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "ms");
    }

}
