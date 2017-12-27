package com.peierlong.coursera.algorithms.week4.interview;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * Taxicab numbers. A taxicab number is an integer that
 * can be expressed as the sum of two cubes of positive
 * integers in two different ways: a^3+b^3=c^3+d^3. For example,
 * 1729 is the smallest taxicab number: 9^3+10^3=1^3+12^3. Design
 * an algorithm to find all taxicab numbers less than n.
 *
 * @author elong
 * @version V1.0
 * @date 2017/12/27
 */
public class FindTaxicabNumber {


    public static Integer[] findAllTaxicabNumber(int n) {
        List<Integer> numbers = new ArrayList<>();
        while (n > 0) {
            int index = 0;
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((i * i * i) + (j * j * j) == n) {
                        if (++index >= 2) {
                            StdOut.println(n + " = " + i + "^3 + " + j + "^3");
                            numbers.add(n--);
                            index = 0;
                            break;
                        }
                    }
                }
            }
            n--;
        }
        return numbers.toArray(new Integer[0]);
    }


    public static void findTaxinumber(int N) {
        MinPQ<Taxicab> candidates = new MinPQ<Taxicab>();

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                Taxicab t = new Taxicab(i, j);
                if (candidates.size() < N) {
                    candidates.insert(t);
                }
                else {
                    Queue<Taxicab> temp = new Queue<Taxicab>();
                    Taxicab min = candidates.delMin();

                    while (candidates.min().equals(min)) {
                        temp.enqueue(candidates.delMin());
                    }

                    if (!t.equals(min)) {
                        candidates.insert(t);
                    } else {
                        temp.enqueue(t);
                    }

                    if (!temp.isEmpty()) {
                        for (Taxicab taxi: temp) {
                            System.out.println(taxi);
                        }
                        System.out.println(min);
                    }
                }
            }
        }
    }

    static class Taxicab implements Comparable<Taxicab> {
        int n1;
        int n2;
        int cube;

        Taxicab(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
            this.cube = n1 * n1 * n1 + n2 * n2 * n2;
        }

        @Override
        public int compareTo(Taxicab that) {
            if (that.cube > this.cube) return -1;
            if (that.cube < this.cube) return 1;
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Taxicab) {
                if (((Taxicab) o).compareTo(this) == 0)
                    return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "number: " + cube + " (" + n1 + ", " + n2 + ")";
        }
    }

    public static void main(String[] args) {
        findTaxinumber(10);
    }


}
