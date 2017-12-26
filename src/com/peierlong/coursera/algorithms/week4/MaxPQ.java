package com.peierlong.coursera.algorithms.week4;

import edu.princeton.cs.algs4.StdRandom;

import java.util.NoSuchElementException;

/**
 * 优先队列的实现
 * 数据结构：二叉堆
 *
 * @author elong
 * @version V1.0
 * @date 2017/12/25
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * lgN
     */
    public void insert(Key key) {
        if (N == pq.length - 1) {
            resize(pq.length * 2);
        }
        pq[++N] = key;
        swim(N);
    }

    /**
     * lgN
     */
    public Key delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = null;
        if (N > 0 && N == (pq.length - 1) / 4) {
            resize(pq.length / 2);
        }
        return max;
    }

/* 随机读取和删除方法 start */
//    public Key 𝚜𝚊𝚖𝚙𝚕𝚎() {
//        if (isEmpty()) {
//            throw new NoSuchElementException("Priority queue underflow");
//        }
//        int index = StdRandom.uniform(1, N);
//        return pq[index];
//    }
//
//    public Key 𝚍𝚎𝚕𝚁𝚊𝚗𝚍𝚘𝚖() {
//        if (isEmpty()) {
//            throw new NoSuchElementException("Priority queue underflow");
//        }
//        int index = StdRandom.uniform(1, N);
//        swim(index);
//        return delMax();
//    }
/* 随机读取和删除方法 end */

    /**
     * 上浮
     */
    public void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 下沉
     */
    public void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[j] = pq[i];
        pq[i] = swap;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void resize(int capacity) {
        assert capacity > N;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= N; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

}
