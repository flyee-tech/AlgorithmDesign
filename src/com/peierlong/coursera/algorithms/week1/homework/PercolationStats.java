package com.peierlong.coursera.algorithms.week1.homework;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96;
    private final int experimentsCount;
    private final double[] fractions;
    private final double mean;
    private final double stddev;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Given N <= 0 || T <= 0");
        }
        experimentsCount = trials;
        fractions = new double[experimentsCount];
        for (int expNum = 0; expNum < experimentsCount; expNum++) {
            Percolation pc = new Percolation(n);
            int openSites = 0;
            while (!pc.percolates()) {
                int p = StdRandom.uniform(1, n + 1);
                int q = StdRandom.uniform(1, n + 1);
                if (!pc.isOpen(p, q)) {
                    pc.open(p, q);
                    openSites++;
                }
            }
            fractions[expNum] = (double) openSites / (n * n);
        }
        mean = StdStats.mean(fractions);
        stddev = StdStats.stddev(fractions);
    }

    public double mean() {
        return mean;
    }

    public double stddev() {
        return stddev;
    }

    public double confidenceLo() {
        return mean - CONFIDENCE_95 * stddev / Math.sqrt(experimentsCount);
    }

    public double confidenceHi() {
        return mean + CONFIDENCE_95 * stddev / Math.sqrt(experimentsCount);
    }

    public static void main(String[] args) {
        int n;
        int t;

        if (args.length == 0) {
            n = 20;
            t = 10;
        } else {
            n = Integer.parseInt(args[0]);
            t = Integer.parseInt(args[1]);
        }

        PercolationStats stats = new PercolationStats(n, t);

        double confidenceLow = stats.confidenceHi();
        double confidenceHigh = stats.confidenceLo();

        StdOut.println("mean                    = " + stats.mean);
        StdOut.println("stddev                  = " + stats.stddev);
        StdOut.println("95% confidence interval = " + confidenceLow + ", "
                + confidenceHigh);
    }


}