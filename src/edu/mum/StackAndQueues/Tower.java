package edu.mum.StackAndQueues;

import java.util.Stack;

/**
 * Created by hungduong on 2/28/17.
 */
/*
 * In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of di erent sizes which can slide onto any tower.
 * The puzzle starts with disks sorted in ascending order of size from top to bottom (e.g., each disk sits on top of an even
 * larger one). You have the following constraints:
 * (A) Only one disk can be moved at a time.
 * (B) A disk is slid o  the top of one rod onto the next rod.
 * (C) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the  rst rod to the last using Stacks.
 */
public class Tower {
    private Stack<Integer> disk;
    private int index;

    public Tower(int i) {
        disk = new Stack<>();
        this.index = i;
    }

    public int index() {
        return index;
    }

    public void add(int d) {
        if(!disk.isEmpty() && disk.peek() < d) {
            System.out.println("Error placing disk " + d);
        } else {
            disk.push(d);
        }
    }

    public void moveTopTo(Tower t) {
        int top = disk.pop();
        t.add(top);
        System.out.println("Move disk " + top + " from " + index() + " to " + t.index());
    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
        if(n > 0) {
            moveDisks(n-1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++)
            towers[i] = new Tower(i);

        for (int i = n - 1; i >= 0; i--)
            towers[0].add(i);

        towers[0].moveDisks(n, towers[2], towers[1]);
    }
}
