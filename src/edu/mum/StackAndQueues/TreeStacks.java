package edu.mum.StackAndQueues;

import java.util.Stack;

/**
 * Created by hungduong on 2/28/17.
 * Describe how you could use a single array to implement three stacks.
 */
public class TreeStacks {
    private int stackSize = 300;
    private int[] stackPoint = {0, 0, 0}; // stack pointers to track top elem
    private int[] buffer = new int[stackSize * 300];

    public TreeStacks(){}

    public void push(int stackNumber, int value) {
        //Find the position to insert
        //It is the top element in array + 1
        int index = stackNumber * stackSize + stackPoint[stackNumber] + 1;
        stackPoint[stackNumber]++;
        buffer[index] = value;
    }

    public int pop(int stackNumber) {
        int index = stackNumber * stackSize + stackPoint[stackNumber];
        stackPoint[stackNumber]--;
        int value = buffer[index];
        buffer[index] = 0;

        return value;
    }

    public int peek(int stackNumber) {
        int index = stackNumber * stackSize + stackPoint[stackNumber];
        return buffer[index];
    }

    public boolean isEmpty(int stackNumber) {
        return stackPoint[stackNumber] == 0;
    }
}
