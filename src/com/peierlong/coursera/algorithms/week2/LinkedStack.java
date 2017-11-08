package com.peierlong.coursera.algorithms.week2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 使用链表实现栈
 * BY: elong
 * ON: 07/11/2017
 */
public class LinkedStack<T> implements Stack<T> {
    private Node<T> first;
    private int size;

    @Override
    public void push(T item) {
        Node<T> oldFirst = first;
        first = new Node<>(oldFirst, item);
        size++;
    }

    @Override
    public T pop() {
        if (first == null) {
            return null;
        }
        T popItem = first.item;
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

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public T next() {
            T item = first.item;
            first = first.next;
            size--;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new LinkedStack<>();
        stack.push("my");
        stack.push("name");
        stack.push("is");
        stack.push("elong");
        StdOut.println(stack.size());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());

        StdOut.println("start iterator");
        for (String s : stack) {
            System.out.println(s);
        }

    }

}
