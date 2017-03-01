package edu.mum.StackAndQueues;

import java.util.Stack;

/**
 * Created by hungduong on 2/28/17.
 */

/*
 * Implement a MyQueue class which implements a queue using two stacks
 */
public class MyQueue<T> {
    Stack<T> s1, s2;

    public MyQueue() {
        s1 = new Stack<T>();
        s2 = new Stack<T>();
    }

    public int size() {
        return s1.size() + s2.size();
    }

    public void add(T value) {
        s1.push(value);
    }

    public T remove() {
        if(!s2.isEmpty()) return s2.pop();

        while(!s1.isEmpty())
            s2.push(s1.pop());

        return s2.pop();
    }

    public T peek() {
        if (!s2.empty())
            return s2.peek();

        while (!s1.empty())
            s2.push(s1.pop());

        return s2.peek();
    }
}
