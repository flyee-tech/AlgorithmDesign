package com.peierlong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peiel
 * @version V1.0
 * @date 2020/5/28
 */
public class N6ZigZag {


    /*
     * 1158 / 1158 test cases passed.
     * Runtime: 6 ms
     * Memory Usage: 40 MB
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        boolean b = false;
        int row = 0;
        for (char aChar : s.toCharArray()) {
            list.get(row).append(aChar);
            if (row == 0 || row == numRows - 1) {
                b = !b;
            }
            row += b ? +1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            sb.append(stringBuilder);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

}
