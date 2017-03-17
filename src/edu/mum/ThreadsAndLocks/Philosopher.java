package edu.mum.ThreadsAndLocks;

/**
 * Created by hungduong on 3/16/17.
 */
public class Philosopher extends Thread{
    private int bites = 10;
    private Chopstick lower, higher;
    private int index; //Label each chopstick is also for each Philosopher

    public Philosopher(int i, Chopstick left, Chopstick right) {
        this.index = i;

        if(left.getNumber() < right.getNumber()) {
            this.lower = left;
            this.higher = right;
        } else {
            this.lower = right;
            this.higher = left;
        }
    }

    public void eat() {
        pickUp();
        chew();
        pushDown();
    }

    public void pickUp() {
        lower.pickup();
        higher.pickup();
    }

    public void chew() {
    }

    public void pushDown() {
        lower.pushDown();
        higher.pushDown();
    }

    public void run() {
        for(int i = 0; i < bites; i++) {
            eat();
        }
    }
}
