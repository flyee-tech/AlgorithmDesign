package com.peierlong.utils;

/**
 * @author Peiel
 * @version V1.0
 * @date 2019/12/24
 */
public class Formater {

    public static String formatBinary(String b, int len) {
        if (b.length() == len) {
            return addSpace(b);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - b.length(); i++) {
            sb.append(0);
        }
        sb.append(b);
        return addSpace(sb.toString());
    }

    private static String addSpace(String source) {
        char[] cs = source.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (i % 4 == 0 && i > 0) {
                sb.append(" ");
            }
            sb.append(cs[i]);
        }
        return sb.toString();
    }


}
