package com.peierlong.leetcode.v2;

public class LC014LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int currentIdx = 0;
        while (true) {
            Character ch = null, prev = null;
            for (String str : strs) {
                char[] chars = str.toCharArray();
                if (chars.length == currentIdx) {
                    currentIdx = -1;
                    ch = null;
                    break;
                }
                ch = chars[currentIdx];
                if (prev != null && prev != ch) {
                    currentIdx = -1;
                    ch = null;
                    break;
                }
                prev = ch;
            }
            if (ch != null) {
                result.append(ch);
            }
            if (currentIdx == -1) {
                break;
            }
            currentIdx++;
        }
        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(new LC014LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(new LC014LongestCommonPrefix().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

}
