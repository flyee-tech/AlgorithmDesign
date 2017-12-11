package com.peierlong.coursera.algorithms.week2.homework;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 数组实现的具有取随机数功能的队列
 *
 * @author elong
 * @version V1.0
 * @date 10/11/2017
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int CAPTURE_DOMAIN = 4;

    private Object[] data;
    private int size;

    public RandomizedQueue() {
        data = new Object[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        verifyItem(item);
        if (size == data.length) {
            resize(data.length * 2);
        }
        data[size++] = item;
    }

    @SuppressWarnings("unchecked")
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        if (size == data.length / CAPTURE_DOMAIN) {
            resize(data.length / 2);
        }
        int index = StdRandom.uniform(size);
        Object item = data[index];
        if (index == size - 1) {
            data[index] = null;
        } else {
            data[index] = data[size - 1];
            data[size - 1] = null;
        }
        size--;
        return (Item) item;
    }

    private void resize(int capacity) {
        Object[] copy = new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = data[i];
        }
        data = copy;
    }

    private void verifyItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("The item is null");
        }
    }

    @SuppressWarnings("unchecked")
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        int index = StdRandom.uniform(size);
        return (Item) data[index];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator<>();
    }

    private class RandomizedQueueIterator<E> implements Iterator<E> {
        private int pointer;
        private int[] shuffleIndex = new int[size];

        public RandomizedQueueIterator() {
            pointer = 0;
            for (int i = 0; i < size; i++) {
                shuffleIndex[i] = i;
            }
            StdRandom.shuffle(shuffleIndex);
        }

        @Override
        public boolean hasNext() {
            return pointer < size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("The queue is empty");
            }
            return (E) data[shuffleIndex[pointer++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        for (String s : queue) {
            StdOut.print(s + " ");
        }
        StdOut.println();
        for (int i = 0; i < 3; i++) {
            StdOut.print(queue.sample() + " ");
        }
    }

}
