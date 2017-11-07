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

    public ArrayStackOfStrings() {
        s = new String[1];
    }

    @Override
    public void push(String item) {
        if (N > 0 && N == s.length) {
            resize(s.length * 2);
        }
        s[N++] = item;
    }

    @Override
    public String pop() {
        if (N > 0 && N == s.length / 4) {
            resize(s.length / 2);
        }
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

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public static void main(String[] args) {
        StackOfStrings stack = new ArrayStackOfStrings();
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
