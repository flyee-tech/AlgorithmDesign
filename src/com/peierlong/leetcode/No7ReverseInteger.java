package com.peierlong.leetcode;

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


    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

}
