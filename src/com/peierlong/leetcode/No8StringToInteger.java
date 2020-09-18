package com.peierlong.leetcode;

/**
 * 8. String to Integer (atoi)
 *
 * @author peierlong
 * @version V1.0
 * @date 2020/9/18
 */
public class No8StringToInteger {


    public static int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        StringBuilder result = new StringBuilder();
        boolean isNegative = false;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (i == 0 && !(isDigit(aChar) || aChar == '-' || aChar == '+')) {
                break;
            }
            if (i == 0 && aChar == '-') {
                isNegative = true;
                continue;
            }
            if (i == 0 && aChar == '+') {
                continue;
            }
            if (isDigit(aChar)) {
                result.append(aChar);
            } else {
                break;
            }
        }
        if (result.length() > 0) {
            try {
                return isNegative ? -Integer.parseInt(result.toString()) : Integer.parseInt(result.toString());
            } catch (NumberFormatException e) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return 0;
    }


    private static boolean isDigit(char c) {
        return (byte) c >= 48 && (byte) c <= 57;
    }


    /**
     * Submission Detail:
     *
     * 1079 / 1079 test cases passed.
     * Status: Accepted
     * Runtime: 3 ms
     * Memory Usage: 39.5 MB
     *
     */
    public static void main(String[] args) {
        System.out.println(myAtoi("+1"));
    }

}
