package com.peierlong.leetcode.v1;

import java.util.*;

/**
 * @author Peiel
 * @version V1.0
 * @date 2019/12/26
 */
public class LengthOfLongestSubstring {

    // 自己写的第一个版本，算是暴力解决法。
    public static int lengthOfLongestSubstring(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder substring = new StringBuilder();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!substring.toString().contains(c + "")) {
                substring.append(c);
            } else {
                list.add(substring.toString());
                i = i - substring.length();
                substring = new StringBuilder();
            }
        }
        list.add(substring.toString());
        System.out.println(list);
        int max = 0;
        for (String s1 : list) {
            int len = s1.length();
            if (len > max) {
                max = len;
            }
        }
        return max;
    }

    // 窗口移动自己没有想到，看了答案后自己实现的。
    // 窗口移动算法，用Set来保存窗口中的内容
    public static int lengthOfLongestSubstring1(String s) {
        int i = 0, j = 0, ans = 0;
        Set<Character> set = new HashSet<>();
        for (; i < s.length() && j < s.length(); ) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    // 窗口移动的优化版本，利用128个int数组来保存所有的字符
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    // Python版本的说超过99%，其实说白了也是用的窗口移动算法。
    public static int lengthOfLongestSubstring3(String s) {
        Map<Object, Integer> map = new HashMap<>();
        int maxSoFar = 0, currMax = 0, start = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int str = chars[i];
            if (map.containsKey(str) && map.get(str) >= start) {
                maxSoFar = Math.max(maxSoFar, currMax);
                currMax = i - map.get(str);
                start = map.get(str) + 1;
            } else {
                currMax += 1;
            }
            map.put(str, i);
        }
        return Math.max(maxSoFar, currMax);
    }


    public static void main(String[] args) {
        int i = lengthOfLongestSubstring3("ababca");
        System.out.println(i);
    }


}
