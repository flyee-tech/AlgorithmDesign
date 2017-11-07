package com.peierlong.coursera.algorithms.week2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 使用数组实现栈
 * BY: elong
 * ON: 07/11/2017
 */
public class ArrayStackOfStrings implements StackOfStrings {
    private String[] s;
    private int N;

    public ArrayStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    @Override
    public void push(String item) {
        s[N++] = item;
    }

    @Override
    public String pop() {
        String item = s[--N];
        s[N] = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    public static void main(String[] args) {
        StackOfStrings stack = new ArrayStackOfStrings(4);
        stack.push("my");
        stack.push("name");
        stack.push("is");
        stack.push("elong");
        StdOut.println(stack.size());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.size());
    }
}
