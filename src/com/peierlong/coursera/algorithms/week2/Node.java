package com.peierlong.coursera.algorithms.week2;

/**
 * 链表的一个节点
 * BY: elong
 * ON: 07/11/2017
 */
public class Node {
    Node next;
    String item;

    Node(Node next, String item) {
        this.next = next;
        this.item = item;
    }
}
