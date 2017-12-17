package com.peierlong.coursera.algorithms.week3;

import java.util.Comparator;

/**
 * @author elong
 * @version V1.0
 * @date 2017/12/17
 */
public class Student implements Comparable<Student> {

    public static Comparator<Student> byName = new ByName();
    public static Comparator<Student> byAge = new ByAge();

    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name: " + this.name + ",age: " + this.age;
    }

    @Override
    public int compareTo(Student that) {
        return this.age.compareTo(that.age);
    }

    static class ByName implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            return s1.name.compareTo(s2.name);
        }
    }

    static class ByAge implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            return s1.age.compareTo(s2.age);
        }
    }

}
