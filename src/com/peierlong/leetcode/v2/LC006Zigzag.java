package com.peierlong.leetcode.v2;

public class LC006Zigzag {

    public static String convert(String s, int numRows) {
        StringBuilder[] arr = new StringBuilder[numRows];
        int currentIdx = 0;
        boolean direction = true;
        int firstLineIdx = 0;
        int lastLineIdx = numRows - 1;
        for (char c : s.toCharArray()) {
            if (arr[currentIdx] == null) {
                arr[currentIdx] = new StringBuilder();
            }
            arr[currentIdx].append(c);
            if (direction && currentIdx < lastLineIdx) {
                currentIdx++;
            }
            if (!direction && currentIdx > firstLineIdx) {
                currentIdx--;
            }
            if (currentIdx == firstLineIdx || currentIdx == lastLineIdx) {
                direction = !direction;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : arr) {
            if (sb != null) {
                ans.append(sb);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {

        String s1 = "AB";
        int i1 = 1;
        String s2 = "PAYPALISHIRING";
        int i2 = 3;

        System.out.println(convert(s1, i1));
        System.out.println(convert(s2, i2));

    }


}