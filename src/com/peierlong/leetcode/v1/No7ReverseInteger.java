package com.peierlong.leetcode.v1;

/**
 * @author Peiel
 * @version V1.0
 * @date 2020/6/16
 */
public class No7ReverseInteger {

    public static int reverse(int x) {
        String xs = String.valueOf(x);
        char[] chars = xs.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (i == 0 && chars[i] == '-') {
                result.insert(0, '-');
            } else {
                result.append(chars[i]);
            }
        }
        try {
            return Integer.parseInt(result.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse2(1534236469));
    }

}
