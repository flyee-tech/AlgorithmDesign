package com.peierlong.leetcode.v2;

import java.util.*;

public class LC017LetterCombinationsOfAPhoneNumber {
    private static final Map<Character, List<String>> map = new HashMap<Character, List<String>>() {{
        put('2', Arrays.asList("a", "b", "c"));
        put('3', Arrays.asList("d", "e", "f"));
        put('4', Arrays.asList("g", "h", "i"));
        put('5', Arrays.asList("j", "k", "l"));
        put('6', Arrays.asList("m", "n", "o"));
        put('7', Arrays.asList("p", "q", "r", "s"));
        put('8', Arrays.asList("t", "u", "v"));
        put('9', Arrays.asList("w", "x", "y", "z"));
    }};

    // 使用递归来实现
    public void loop(List<String> result, int idx, String curStr, char[] digitsChars) {
        // 递归的结束条件：目标字符和输入字符长度相同时
        if (curStr.length() == digitsChars.length) {
            result.add(curStr);
            return;
        }
        // 每次递归都会遍历当前索引下的字符，向下一层拼接
        for (String s : map.get(digitsChars[idx])) {
            loop(result, idx + 1, curStr + s, digitsChars);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.equals("")) {
            return result;
        }
        loop(result, 0, "", digits.toCharArray());
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LC017LetterCombinationsOfAPhoneNumber().letterCombinations(""));
        System.out.println(new LC017LetterCombinationsOfAPhoneNumber().letterCombinations("9"));
        System.out.println(new LC017LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
        System.out.println(new LC017LetterCombinationsOfAPhoneNumber().letterCombinations("234"));
    }

}
