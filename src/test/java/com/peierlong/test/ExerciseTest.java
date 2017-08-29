package com.peierlong.test;

import com.peierlong.exercise.ParseString;
import org.junit.Test;

/**
 * BY: elong
 * ON: 29/08/2017
 */
public class ExerciseTest {

    @Test
    public void testParseString() {
        String s = "abcd\nefggg\n\n\nhijklmmmmmm\n\n\n\n\n\nnn";
        String s1 = ParseString.testString(s);
        System.out.println("原字符串 >> " + s);
        System.out.println("处理后字符串 >> " + s1);
    }

}
