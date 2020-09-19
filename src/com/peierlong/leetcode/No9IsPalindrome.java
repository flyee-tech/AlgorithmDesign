package com.peierlong.leetcode;

/**
 * 9. Palindrome Number
 *
 * @author peierlong
 * @version V1.0
 * @date 2020/9/19
 */
public class No9IsPalindrome {

    public static boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int lo = 0;
        int hi = chars.length - 1;
        while (lo < hi) {
            if (chars[lo++] != chars[hi--]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeOptimal(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertNumber = 0;
        while (x > revertNumber) {
            revertNumber = revertNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertNumber || x == revertNumber / 10;
    }

    public static void main(String[] args) {
        boolean b = isPalindromeOptimal(13231);
        System.out.println(b);
    }

}
