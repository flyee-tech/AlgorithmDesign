package com.peierlong.coursera.algorithms.week4.interview;

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

    public static void main(String[] args) {
        Integer[] a = findAllTaxicabNumber(4000);
        for (Integer i : a) {
            StdOut.println(i);
        }
    }


}
