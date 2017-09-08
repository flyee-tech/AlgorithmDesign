package com.peierlong.exercise;

import java.util.Map;

/**
 * BY: elong
 * ON: 08/09/2017
 */
public class DynamicProgramming {

    /**
     * 时间复杂度 O(n)
     * 如果没有备忘录算法 时间复杂度为 O(2^n)
     */
    public static long getClimbingWays(long n, Map<Long, Long> map) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            long val = getClimbingWays(n - 1, map) + getClimbingWays(n - 2, map);
            map.put(n, val);
            return val;
        }
    }

    /**
     * 时间复杂度O(1)
     */
    public static long getClimbingWays2(long n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        long a = 1;
        long b = 2;
        long temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

}
