package com.peierlong.coursera.algorithms.week2.homework;

import com.peierlong.coursera.algorithms.week2.ArrayStack;
import com.peierlong.coursera.algorithms.week2.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 求栈中最大值实现
 * BY: elong
 * ON: 09/11/2017
 */
public class MaximumNumbersStack {

    private Stack<Integer> dataStack = new ArrayStack<>(),
            maxStack = new ArrayStack<>();

    public void push(int item) {
        dataStack.push(item);
        if (maxStack.isEmpty() || maxStack.peek() <= item) {
            maxStack.push(item);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    public int pop() {
        maxStack.pop();
        return dataStack.pop();
    }

    public int maximumNumber() {
        return maxStack.peek();
    }

    public static void main(String[] args) {
        MaximumNumbersStack stack = new MaximumNumbersStack();
        stack.push(1);
        stack.push(4);
        stack.push(1);
        stack.push(9);
        stack.push(7);
        stack.push(8);
        StdOut.println(stack.maximumNumber());
    }

}
