package com.peierlong.coursera.algorithms.week1.homework;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * 渗透问题
 * Programming Assignment 1: Percolation
 *
 * @author elong
 * @date 06/11/2017
 */
public class Percolation {

    private final int topIndex;     //在顶部创建个虚拟节点
    private final int buttonIndex;  //在底部创建个虚拟节点
    private final int n;            //宽度
    private boolean[] isOpenSign;   //为每个节点标记open的数组
    private int openNumber;         //记录open的数量
    private final WeightedQuickUnionUF uf;  //和顶部底部全部相连的并查集（直接判断顶部和底部节点是否相通就可以判断是否渗透）
    private final WeightedQuickUnionUF backWashUf;  //只和顶部节点相连的并查集（可以判断是否渗透到某个节点）

    public Percolation(int N) {
        if (N < 1) {
            throw new IllegalArgumentException("the N mast gt 0");
        }
        topIndex = 0;
        buttonIndex = N * N + 1;
        n = N;
        isOpenSign = new boolean[N * N + 2];
        for (int i = 0; i < N * N + 2; i++) {
            isOpenSign[i] = false;
        }
        openNumber = 0;
        uf = new WeightedQuickUnionUF(N * N + 2);
        backWashUf = new WeightedQuickUnionUF(N * N + 1);
    }

    public void open(int row, int col) {
        verifyRowAndCol(row, col);
        if (isOpen(row, col)) {
            return;
        }
        int currentIndex = xyToIndex(row, col);
        isOpenSign[currentIndex] = true;
        if (row == 1) {
            uf.union(topIndex, currentIndex);
            backWashUf.union(topIndex, currentIndex);
        }
        if (row == n) {
            uf.union(buttonIndex, currentIndex);
        }
        if (!isOutOfBound(row, col - 1) && isOpen(row, col - 1)) {
            uf.union(currentIndex, currentIndex - 1);
            backWashUf.union(currentIndex, currentIndex - 1);
        }
        if (!isOutOfBound(row, col + 1) && isOpen(row, col + 1)) {
            uf.union(currentIndex, currentIndex + 1);
            backWashUf.union(currentIndex, currentIndex + 1);
        }
        if (!isOutOfBound(row - 1, col) && isOpen(row - 1, col)) {
            uf.union(currentIndex, currentIndex - n);
            backWashUf.union(currentIndex, currentIndex - n);
        }
        if (!isOutOfBound(row + 1, col) && isOpen(row + 1, col)) {
            uf.union(currentIndex, currentIndex + n);
            backWashUf.union(currentIndex, currentIndex + n);
        }
        openNumber++;
    }

    public boolean isOpen(int row, int col) {
        verifyRowAndCol(row, col);
        return isOpenSign[xyToIndex(row, col)];
    }

    public boolean isFull(int row, int col) {
        verifyRowAndCol(row, col);
        return backWashUf.connected(topIndex, xyToIndex(row, col));
    }

    public int numberOfOpenSites() {
        return openNumber;
    }

    public boolean percolates() {
        return uf.connected(topIndex, buttonIndex);
    }

    private int xyToIndex(int row, int col) {
        return (row - 1) * n + col;
    }

    private boolean isOutOfBound(int row, int col) {
        return row <= 0 || row > n || col <= 0 || col > n;
    }

    private void verifyRowAndCol(int row, int col) {
        if (row <= 0 || row > n || col <= 0 || col > n) {
            throw new IllegalArgumentException("index out of bounds");
        }
    }

    public static void main(String[] args) {
        Percolation perc = new Percolation(1);
        perc.open(1, 1);
        StdOut.println(perc.percolates());
        StdOut.println(perc.numberOfOpenSites());
    }

}
