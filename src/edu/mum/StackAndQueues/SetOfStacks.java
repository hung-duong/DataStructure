package edu.mum.StackAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hungduong on 2/28/17.
 */

/*
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. There- fore, in real life, we would likely
 * start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks that mimics this.
 * SetOf- Stacks should be composed of several stacks, and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop() should return the same
 * values as it would if there were just a single stack).
 */

public class SetOfStacks {
    List<Stack> stacks = new ArrayList<Stack>();
    public int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack() {
        if(stacks.isEmpty())
            return null;

        return stacks.get(stacks.size() - 1);
    }

    public void push(int value) {
        Stack last = getLastStack();

        if(last != null) {
            last.push(value);
        }
        else {
            Stack stack = new Stack();
            stack.push(value);
            stacks.add(stack);
        }
    }

    public int pop() {
        Stack last = getLastStack();

        int v = (Integer) last.pop();
        if(last.size() == 0)
            stacks.remove(stacks.size() - 1);

        return v;
    }
}
