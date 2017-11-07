package com.peierlong.coursera.algorithms.week1.homework;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Programming Assignment 1: Percolation
 * BY: elong
 * ON: 06/11/2017
 */
public class Percolation {

    private int topIndex;
    private int buttonIndex;
    private int n;
    private boolean[] isOpenSign;
    private int openNumber;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF backWashUf;

    public Percolation(int N) {
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
        } else if (row == n) {
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
        Percolation perc = new Percolation(3);
        perc.open(1, 1);
        perc.open(1, 2);
        perc.open(2, 2);
        perc.open(2, 3);
        perc.open(3, 1);
        perc.open(3, 3);
        StdOut.println(perc.percolates());
        StdOut.println(perc.numberOfOpenSites());
    }

}
