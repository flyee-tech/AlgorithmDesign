package com.peierlong.leetcode;

/**
 * 10. Regular Expression Matching
 *
 * @author peierlong
 * @version V1.0
 * @date 2020/9/20
 */
public class No10reMatching {

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (pc == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        System.out.println(isMatch("aa", "aa") == true);
        System.out.println(isMatch("aa", "a") == false);
        System.out.println(isMatch("aa", "a*") == true);
        System.out.println(isMatch("ab", ".*") == true);
        System.out.println(isMatch("aab", "c*a*b") == true);
        System.out.println(isMatch("mississippi", "mis*is*p*.") == false);
        System.out.println(isMatch("mississi", "mis*is*p*.") == true);
        System.out.println(isMatch("aaa", "a*a") == true);
        System.out.println(isMatch("aaa", "ab*a*c*a") == true);
        System.out.println(isMatch("bbbba", ".*a*a") == true);
        System.out.println(isMatch("ab", ".*..") == true);
    }

}
