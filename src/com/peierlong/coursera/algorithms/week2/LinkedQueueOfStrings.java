package com.peierlong.coursera.algorithms.week2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 使用链表实现队列
 * BY: elong
 * ON: 08/11/2017
 */
public class LinkedQueueOfStrings implements QueueOfStrings {
    private int size;
    private Node first, last;

    @Override
    public void enqueue(String item) {
        Node newNode = new Node(null, item);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        String item = first.item;
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
        QueueOfStrings queue = new LinkedQueueOfStrings();
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
