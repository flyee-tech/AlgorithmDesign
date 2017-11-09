package com.peierlong.coursera.algorithms.week2;

/**
 * 链表的一个节点
 * BY: elong
 * ON: 07/11/2017
 */
public class Node<T> {
    public Node<T> next;
    public T item;

    public Node(Node<T> next, T item) {
        this.next = next;
        this.item = item;
    }
}
