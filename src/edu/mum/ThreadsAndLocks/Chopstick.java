package edu.mum.ThreadsAndLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hungduong on 3/16/17.
 */
public class Chopstick {
    private Lock lock;
    private int number;
    private String str; //left or right

    public Chopstick(int n, String str) {
        this.lock = new ReentrantLock();
        this.number = n;
        this.str = str;
    }

    public boolean pickup() {
        System.out.println("Pickup " + str + " Chopstick");
        //lock.lock();
        return lock.tryLock();
    }

    public void pushDown() {
        System.out.println("pushDown " + str + " Chopstick");
        lock.unlock();
    }

    public int getNumber() {
        return number;
    }
}
