package com.peierlong.coursera.algorithms.week2.homework;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 链表的双向队列的实现
 *
 * @author elong
 * @date 09/11/2017
 */
public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    public Deque() {
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        verifyItem(item);
        Node<Item> f = first;
        first = new Node<>(item, null, f);
        if (f == null) {
            last = first;
        } else {
            f.next = first;
        }
        size++;
    }

    public void addLast(Item item) {
        verifyItem(item);
        Node<Item> l = last;
        last = new Node<>(item, l, null);
        if (l == null) {
            first = last;
        } else {
            l.prev = last;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("the deque is empty");
        }
        Item item = first.item;
        first = first.prev;
        if (first != null) {
            first.next = null;
        } else {
            last = null;
        }
        size--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("the deque is empty");
        }
        Item item = last.item;
        last = last.next;
        if (last != null) {
            last.prev = null;
        } else {
            first = null;
        }
        size--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator<>();
    }

    private void verifyItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("the item is null");
        }
    }

    private class Node<E> {
        private final E item;
        private Node<E> next;
        private Node<E> prev;

        Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private class DequeIterator<E> implements Iterator<E> {

        private Node<Item> current = last;
        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("the deque no more item to return");
            }
            Item item = current.item;
            current = current.next;
            i--;
            return (E) item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("iterator can't remove item");
        }
    }


    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addLast("c");
        deque.addLast("d");

        StdOut.println(deque.removeFirst());
        StdOut.println(deque.removeLast());

        for (String s : deque) {
            System.out.println(s);
        }
    }
}
