package com.peierlong.base;

import org.junit.Test;

/**
 *
 * 欧几里得算法实现
 *
 * BY: elong
 * ON: 26/08/2017
 */
public class Euclid {

    @Test
    public void testEuclid() {
        int gcd = gcd(22, 33);
        System.out.println(gcd);
    }

    private static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

}
