package com.peierlong.leetcode.v2;

import java.util.HashMap;
import java.util.Map;

public class LC013RomanToInteger {


    private static final Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('V', 5);
        put('I', 1);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int romanToInt(String s) {
        int sum = 0;
        int prev = 0;
        for (char ch : s.toCharArray()) {
            Integer current = map.get(ch);
            if (current <= prev) {
                sum += current;
            } else {
                sum += current - prev - prev;
            }
            prev = current;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

}
