package com.peierlong.coursera.algorithms.week2;

/**
 * BY: elong
 * ON: 08/11/2017
 */
public interface Queue<T> {

    void enqueue(T name);

    T dequeue();

    boolean isEmpty();

    int size();

}
