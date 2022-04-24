package com.peierlong.leetcode.v2;

import java.util.HashSet;
import java.util.Set;

public class LC003LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int n = s.length();
        int first = 0;
        int last = 0;
        Set<Character> set = new HashSet<>();
        while (first < n && last < n) {
            if (set.contains(s.charAt(last))) {
                set.remove(s.charAt(first++));
            } else {
                set.add(s.charAt(last++));
                res = Math.max(res, last - first);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcaaaa"));
    }

}
