package edu.mum.StackAndQueues;

import java.util.Stack;

/**
 * Created by hungduong on 2/28/17.
 */
/*
 * How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 */
public class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value) {
        int newMin = Math.min(value, min());

        this.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if(this.empty())
            return Integer.MAX_VALUE;

        return this.peek().min;
    }
}


