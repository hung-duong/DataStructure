package edu.mum.StackAndQueues;

import java.util.Arrays;

/**
 * Created by hungduong on 4/15/17.
 */
public class CircularQueueResizable {
    // circular buffer, circular queue, cyclic buffer or ring buffer is a data structure that uses a single, fixed-size buffer
    // as if it were connected end-to-end.
    private int capacity;
    private int[] items;
    private int head, tail;
    private int currentSize;

    public CircularQueueResizable() {
        this.capacity = 2;
        items = new int[capacity];
        head = 0;
        tail = -1;
        currentSize = 0;
    }

    private void resize(int capacity) {
        assert capacity >= this.capacity;
        items = Arrays.copyOf(items, capacity);
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isQueueFull() {
        return currentSize == capacity;
    }

    public int size() {
        return currentSize;
    }

    public int length() {
        return capacity;
    }

    public int peek() {
        if(isEmpty()) throw new IllegalStateException("Resizable Queue is underflow");

        return items[head];
    }

    public void enqueue(int item) {
        if(isQueueFull()) {
            resize(2 * capacity);
        }

        tail++;
        if(tail == capacity) {
            tail = 0;
        }

        items[tail] = item;
        currentSize++;
    }

    public int dequeue() {
        if(isEmpty())
            throw new IllegalStateException("Resizable Queue is underflow");

        int item = items[head];

        head++;
        if(head == capacity) {
            head = 0;
        }

        currentSize--;
        return item;
    }

    public static void main(String[] args) {
        CircularQueueResizable queue = new CircularQueueResizable();
        int[] items = {1, 2, 3, 4, 5, 6};

        for (int item : items) {
            //queue.enqueue(item);
        }

        while(!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
