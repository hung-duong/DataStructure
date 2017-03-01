package edu.mum.StackAndQueues;

/**
 * Created by hungduong on 2/28/17.
 * In this approach, any stack can grow as long as there is any free space in the array.
 * We sequentially allocate space to the stacks and we link new blocks to the previous block. This means any new element in a stack
 * keeps a pointer to the previous top element of that particular stack.
 */
public class TreeStacks2 {
    private int stackSize = 300;
    private int indexUsed = 0;
    private int[] stackPoint = {-1, -1, -1}; // stack pointers to track top elem
    private StackNode[] buffer = new StackNode[stackSize * 300];

    class StackNode {
        public int value;
        public int previous;

        public StackNode(int v, int p) {
            this.value = v;
            this.previous = p;
        }
    }

    public TreeStacks2(){}

    public void push(int stackNumber, int value) {
        int lastIndex = stackPoint[stackNumber];
        stackPoint[stackNumber] = indexUsed;
        indexUsed++;
        buffer[stackPoint[stackNumber]] = new StackNode(value, lastIndex);
    }

    public int pop(int stackNumber) {
        int value = buffer[stackPoint[stackNumber]].value;
        int lastIndex = stackPoint[stackNumber];
        stackPoint[stackNumber] = buffer[stackPoint[stackNumber]].previous;
        buffer[lastIndex] = null;
        indexUsed--;

        return value;
    }

    public int peek(int stackNumber) {
        return buffer[stackPoint[stackNumber]].value;
    }

    public boolean isEmpty(int stackNumber) {
        return stackPoint[stackNumber] == -1;
    }
}
