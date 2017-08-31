package com.peierlong.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * BY: elong
 * ON: 29/08/2017
 */
public class ParseString {


    public static String testString(String s) {
        List list = StringConvertList(s);

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals('\n')) {
                sum += 2;
            }
            int index = i;
            for (int j = 0; j < sum && !list.get(index + 1).equals('\n'); j++) {
                list.remove(i - j);
                if (j == sum - 1) {
                    sum = 0;
                }
                if (list.size() - 1 == index) {
                    index--;
                }
            }
        }

        return listConvertString(list);
    }

    private static List StringConvertList(String s) {
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        return list;
    }

    private static String listConvertString(List list) {
        StringBuilder result = new StringBuilder();
        for (Object c : list) {
            result.append(c);
        }
        return result.toString();
    }
}
