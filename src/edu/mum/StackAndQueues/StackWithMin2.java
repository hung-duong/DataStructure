package edu.mum.StackAndQueues;

import java.util.Stack;

/**
 * Created by hungduong on 2/28/17.
 */

/*
 * There’s just one issue with NodeWithMin: if we have a large stack, we waste a lot of space by keeping track of the min for every
 * single element. Can we do better?
 * We can (maybe) do a bit better than this by using an additional stack which keeps track of the mins.
 */
public class StackWithMin2 extends Stack<Integer>{
    Stack<Integer> minStack = new Stack<>();

    public void push(int value) {
        if(value <= min())
            minStack.push(value);

        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();

        if(value == min())
            minStack.pop();

        return value;
    }

    public int min() {
        if(minStack.isEmpty())
            return Integer.MAX_VALUE;

        return minStack.peek();
    }
}
