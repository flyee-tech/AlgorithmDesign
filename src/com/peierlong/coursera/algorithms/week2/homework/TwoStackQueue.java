package com.peierlong.coursera.algorithms.week2.homework;

import com.peierlong.coursera.algorithms.week2.LinkedStack;
import com.peierlong.coursera.algorithms.week2.Queue;
import com.peierlong.coursera.algorithms.week2.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * BY: 使用两个栈实现一个队列
 * ON: 09/11/2017
 */
public class TwoStackQueue<E> implements Queue<E> {

    private Stack<E> outStack = new LinkedStack<>();
    private Stack<E> inStack = new LinkedStack<>();
    private int size;

    @Override
    public void enqueue(E name) {
        inStack.push(name);
        size++;
    }

    @Override
    public E dequeue() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        size--;
        return outStack.pop();
    }

    @Override
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        TwoStackQueue<String> queue = new TwoStackQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        while (!queue.isEmpty()) {
            StdOut.println(queue.dequeue());
        }
    }

}
