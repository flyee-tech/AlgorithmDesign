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
        //init numRows arr
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            StringBuilder sb = new StringBuilder();
            list.add(sb);
        }
        boolean b = true;
        int i = 0;
        for (char aChar : s.toCharArray()) {
            list.get(i).append(aChar);
            if (i == 0) {
                b = true;
            }
            if (i == numRows - 1) {
                b = false;
            }
            if (b) {
                i++;
            }
            if (!b && i >= 1) {
                i--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            result.append(stringBuilder);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

}
