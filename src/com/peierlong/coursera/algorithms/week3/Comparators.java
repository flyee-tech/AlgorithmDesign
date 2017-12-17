package com.peierlong.coursera.algorithms.week3;

import com.peierlong.coursera.algorithms.week2.Shuffle;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Java Comparator 的应用
 *
 * @author elong
 * @version V1.0
 * @date 2017/12/17
 */
public class Comparators {


    public static void main(String[] args) {
        Student s1 = new Student("zs", 1);
        Student s2 = new Student("ls", 4);
        Student s3 = new Student("ww", 5);
        Student s4 = new Student("al", 6);
        Student[] s = {s1, s2, s3, s4};

        Shuffle.shuffle(s);

        for (Student student : s) {
            StdOut.print(student + "  ");
        }

        Arrays.sort(s, Student.byAge);

        StdOut.println();
        for (Student student : s) {
            StdOut.print(student + "  ");
        }
    }

}

