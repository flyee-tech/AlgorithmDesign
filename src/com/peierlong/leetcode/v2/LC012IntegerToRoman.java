package com.peierlong.leetcode.v2;

public class LC012IntegerToRoman {

    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (num > 0) {
            int k = num / values[i];
            for (int j = 0; j < k; j++) {
                sb.append(symbols[i]);
                num -= values[i];
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(1234));
    }

}
