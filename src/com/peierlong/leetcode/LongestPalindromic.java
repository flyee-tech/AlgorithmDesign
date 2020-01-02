package com.peierlong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode5
 *
 * @author Peiel
 * @version V1.0
 * @date 2019/12/31
 */
public class LongestPalindromic {

    /**
     * Brute Force
     */
    public static String solution1(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalindromic(sub) && sub.length() > ans.length()) {
                    ans = sub;
                }
            }
        }
        return ans;
    }

    public static boolean isPalindromic(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 反转字符串，求相同的子串
     */
    public static String solution2(String s) {
        int n = s.length();
        List<String> oriList = new ArrayList<>();
        List<String> reverseList = new ArrayList<>();
        String reverse = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                StringBuilder sb = new StringBuilder();
                for (int z = i; z < j; z++) {
                    sb.append(z);
                }
                oriList.add(s.substring(i, j) + "," + sb);
                sb = new StringBuilder();
                for (int z = j - 1; z >= i; z--) {
                    sb.append(n - z - 1);
                }
                reverseList.add(reverse.substring(i, j) + "," + sb);
            }
        }
        System.out.println(oriList);
        System.out.println(reverseList);

        String ans = "";
        for (String s1 : oriList) {
            if (reverseList.contains(s1)) {
                System.out.println("s1:" + s1);
                s1 = s1.split(",")[0];
                if (s1.length() > ans.length()) {
                    ans = s1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(solution1("aa"));
        String s = "c";
        System.out.println(isPalindromic(s));
    }

}
