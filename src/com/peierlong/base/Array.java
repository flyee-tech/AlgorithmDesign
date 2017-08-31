package com.peierlong.base;

/**
 * BY: elong
 * ON: 29/08/2017
 */
public class Array {

    /**
     * 求数组最大值
     *
     * @param src The source array
     * @return max
     */
    public static int max(int[] src) {
        int max = src[0];
        for (int i : src) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    /**
     * 求平均值
     *
     * @param src The source array
     * @return 平均值
     */
    public static double average(int[] src) {
        double sum = 0.0;
        for (int i : src) {
            sum += i;
        }
        return sum / src.length;
    }

    /**
     * 数据复制
     *
     * @param src The source array
     * @return The destination array
     */
    public static Object[] copy(Object[] src) {
        Object[] dest = new Object[src.length];
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
        return dest;
    }

    /**
     * 数组反转
     *
     * @param src source array
     */
    public static void reverse(Object[] src) {
        int N = src.length;
        for (int i = 0; i < N / 2; i++) {
            Object temp = src[i];
            src[i] = src[N - 1 - i];
            src[N - 1 - i] = temp;
        }
    }

}
