package com.peierlong.test;

import com.peierlong.base.Euclid;
import org.junit.Test;

/**
 * BY: elong
 * ON: 27/08/2017
 */
public class BaseTest {

    @Test
    public void testEuclid() {
        System.out.println("---- Euclid 求22和33的最大公约数？ ---------");
        int gcd = Euclid.gcd(22, 33);
        System.out.println(gcd);
        System.out.println("---------- Euclid end -------------");
    }

}
