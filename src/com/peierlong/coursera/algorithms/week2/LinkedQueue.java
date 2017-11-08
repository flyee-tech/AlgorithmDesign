package com.peierlong.coursera.algorithms.week2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 使用链表实现队列
 * BY: elong
 * ON: 08/11/2017
 */
public class LinkedQueue<T> implements Queue<T> {
    private int size;
    private Node<T> first, last;

    @Override
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(null, item);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = first;
        }
        size--;
        return item;
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
        Queue<String> queue = new LinkedQueue<>();
        String s = "to be or not to be";
        for (String s1 : s.split(" ")) {
            queue.enqueue(s1);
        }
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
    }
}
