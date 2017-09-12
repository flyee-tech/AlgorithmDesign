package com.peierlong.base;

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
        test1_1_6();
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

}
