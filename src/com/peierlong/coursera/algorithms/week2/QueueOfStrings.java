package com.peierlong.coursera.algorithms.week2;

/**
 * BY: elong
 * ON: 08/11/2017
 */
public interface QueueOfStrings {

    void enqueue(String name);

    String dequeue();

    boolean isEmpty();

    int size();

}
