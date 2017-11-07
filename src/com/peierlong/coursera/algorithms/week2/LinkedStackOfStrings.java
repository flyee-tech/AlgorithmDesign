package com.peierlong.coursera.algorithms.week2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 使用链表实现栈
 * BY: elong
 * ON: 07/11/2017
 */
public class LinkedStackOfStrings implements StackOfStrings {
    private Node first;
    private int size;

    @Override
    public void push(String item) {
        Node oldFirst = first;
        first = new Node(oldFirst, item);
        size++;
    }

    @Override
    public String pop() {
        if (first == null) {
            return null;
        }
        String popItem = first.item;
        first = first.next;
        size--;
        return popItem;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        StackOfStrings stack = new LinkedStackOfStrings();
        stack.push("my");
        stack.push("name");
        stack.push("is");
        stack.push("elong");
        StdOut.println(stack.size());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
    }


}
