package com.peierlong.base;

/**
 * 欧几里得算法实现
 *
 * BY: elong
 * ON: 26/08/2017
 */
public class Euclid {

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

}
