package com.peierlong.coursera.algorithms.week2;

/**
 * 链表的一个节点
 * BY: elong
 * ON: 07/11/2017
 */
public class Node<T> {
    Node<T> next;
    T item;

    Node(Node<T> next, T item) {
        this.next = next;
        this.item = item;
    }
}
