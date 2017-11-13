package com.peierlong.coursera.algorithms.week1.homework;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
    private final double[] x;
    private final int expTimes;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Illeagal Argument");
        }
        x = new double[trials + 1];
        expTimes = trials;
        for (int i = 1; i <= trials; ++i) {
            Percolation perc = new Percolation(n);
            boolean[] isEmptySiteLine = new boolean[n + 1];
            int numOfLine = 0;
            while (true) {
                int posX, posY;
                do {
                    posX = StdRandom.uniform(n) + 1;
                    posY = StdRandom.uniform(n) + 1;
                } while (perc.isOpen(posX, posY));
                perc.open(posX, posY);
                x[i] += 1;
                if (!isEmptySiteLine[posX]) {
                    isEmptySiteLine[posX] = true;
                    numOfLine++;
                }
                if (numOfLine == n) {
                    if (perc.percolates()) {
                        break;
                    }
                }
            }
            x[i] = x[i] / (double) (n * n);
        }
    }

    public double mean() {
        double mu = 0.0;
        for (int i = 1; i <= expTimes; ++i) {
            mu += x[i];
        }
        return mu / (double) expTimes;
    }

    public double stddev() {
        if (expTimes == 1) {
            return Double.NaN;
        }
        double sigma = 0.0;
        double mu = mean();
        for (int i = 1; i <= expTimes; ++i) {
            sigma += (x[i] - mu) * (x[i] - mu);
        }
        return Math.sqrt(sigma / (double) (expTimes - 1));
    }

    public double confidenceLo() {
        double mu = mean();
        double sigma = stddev();
        return mu - 1.96 * sigma / Math.sqrt(expTimes);
    }

    public double confidenceHi() {
        double mu = mean();
        double sigma = stddev();
        return mu + 1.96 * sigma / Math.sqrt(expTimes);
    }

    public static void main(String[] args) {
        int n;
        int t;

        if (args.length == 0) {
            n = 100;
            t = 10;
        } else {
            n = Integer.parseInt(args[0]);
            t = Integer.parseInt(args[1]);
        }

        // double startTime = System.nanoTime();
        PercolationStats stats = new PercolationStats(n, t);

        double confidenceLow = stats.confidenceHi();
        double confidenceHigh = stats.confidenceLo();

        StdOut.println("mean                    = " + stats.mean());
        StdOut.println("stddev                  = " + stats.stddev());
        StdOut.println("95% confidence interval = " + confidenceLow + ", "
                + confidenceHigh);
    }


}