package com.peierlong.dailycoding;

/**
 * #959 Daily Coding Problem: Problem [Easy]
 * <p>
 * Good morning! Here's your coding interview problem for today.
 * This problem was asked by Pivotal.
 * Write an algorithm that finds the total number of set bits in all integers between 1 and N.
 *
 * @author peiel
 * @version V1.0
 * @date 2021/8/5
 */
public class SetNitsInAllIntegers {

    private static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            // n对1做位与运算，可以得出最后一位是1或者是0
            count += n & 1;
            // n 右移一位
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int v = countSetBits(i);
            System.out.println(i + " count set bits is : " + v);
        }
    }

}
