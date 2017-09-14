package com.peierlong.base;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.1节 课后练习
 **/
public class Exercise1_1 {

    public static void main(String[] args) {
        // test1_1_1();
        // test1_1_2();
        // test1_1_5(0);
        // test1_1_5(0.2);
        // test1_1_5(1.0);
//        test1_1_6();
//        test1_1_7();
//        test1_1_8();
//        test1_1_9();
//        test1_1_12();
//        test1_1_13();

        int[] a = {1, 1, 2, 3, 4, 5, 5, 9, 3, 3, 3, 3, 2, 1, 7, 7, 7, 7, 4, 3, 3, 2, 3, 8, 1, 0, 0};
        int[] b = test1_1_15(a, 10);
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            System.out.println("第" + i + "个元素个数:" + b[i]);
            sum += b[i];
        }
        System.out.println("元素之和: " + sum);
        System.out.println("参数数组的length: " + a.length);

    }


    public static void test1_1_1() {
        System.out.println((0 + 15) / 2);
        System.out.println(2.0E-6 * 100000000.1);
        System.out.println(true && false || true && false);
    }

    public static void test1_1_2() {
        System.out.println((1 + 2.236) / 2);
        System.out.println(1 + 2 + 3 + 4.0);
        System.out.println(4.1 >= 4);
        System.out.println(1 + 2 + "3");
    }

    public static void test1_1_5(double d) {
        if (d > 0 && d < 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void test1_1_6() {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

    public static void test1_1_7() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > 0.001) {
            t = (9.0 / t + t) / 2.0;
        }
        StdOut.printf("%.5f\n", t);

        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);

        int sum2 = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum2++;
            }
        }
        StdOut.println(sum2);
    }

    public static void test1_1_8() {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));
    }


    public static void test1_1_9() {
        // JDK实现
        String s = Integer.toBinaryString(100);
        System.out.println(s);

        // 书中实现
        String s1 = "";
        for (int n = 100; n > 0; n /= 2) {
            System.out.println(n);
            s1 = (n % 2) + s1;
        }
        System.out.println(s1);
    }

    public static void test1_1_12() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }

    public static void test1_1_13() {
        int[][] a = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = j;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StdOut.print(a[j][i] + " ");
            }
            StdOut.println();
        }
    }

    public static int[] test1_1_15(int[] a, int M) {
        int[] b = new int[M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] == i) {
                    b[i]++;
                }
            }
        }
        return b;
    }

}
