package edu.mum.StackAndQueues;

import edu.mum.Util.ListNode;

/**
 * Created by hungduong on 4/15/17.
 */
public class QueueLinkedList {
    private int n;
    private ListNode head;
    private ListNode tail;

    public QueueLinkedList() {
        head = null;
        tail = null;
        n = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return n;
    }

    public int length() {
        return n;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue underflow");
        return head.val;
    }

    public void enqueue(int item) {
        ListNode temp = tail;
        tail = new ListNode();
        tail.val = item;
        tail.next = null;

        if(isEmpty()) head = tail;
        else temp.next = tail;
        n++;
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue underflow");
        int item = head.val;
        head = head.next;
        n--;

        if(isEmpty()) tail = null;

        return item;
    }
}
