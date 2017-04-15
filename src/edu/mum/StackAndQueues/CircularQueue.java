package edu.mum.StackAndQueues;

/**
 * Created by hungduong on 4/15/17.
 */
public class CircularQueue {
    // circular buffer, circular queue, cyclic buffer or ring buffer is a data structure that uses a single, fixed-size buffer
    // as if it were connected end-to-end.
    private int capacity;
    private int[] items;
    private int head, tail;
    private int currentSize;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
        head = 0;
        tail = -1;
        currentSize = 0;
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
        if(isEmpty()) throw new IllegalStateException("Queue is underflow");

        return items[head];
    }

    public void enqueue(int item) {
        if(isQueueFull()) throw new IllegalStateException("Queue is full");

        tail++;
        if(tail == capacity) {
            tail = 0;
        }

        items[tail] = item;
        currentSize++;
    }

    public int dequeue() {
        if(isEmpty()) throw new IllegalStateException("Queue is underflow");
        int item = items[head];

        head++;
        if(head == capacity) {
            head = 0;
        }

        currentSize--;
        return item;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(10);
        int[] items = {1, 2, 3, 4, 5, 6};

        for (int item : items) {
            queue.enqueue(item);
        }

        while(!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
