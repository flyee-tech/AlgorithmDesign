package com.peierlong.coursera.algorithms.week2;

/**
 * BY: elong
 * ON: 07/11/2017
 */
public interface Stack<T> extends Iterable<T>{

    void push(T item);

    T pop();

    T peek();

    boolean isEmpty();

    int size();
}
