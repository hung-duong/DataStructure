package edu.mum.ThreadsAndLocks;

/**
 * Created by hungduong on 3/16/17.
 */
public class Philosopher extends Thread{
    private int bites = 10;
    private Chopstick left, right;

    public Philosopher(Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
    }

    public void eat() {
        if(pickUp()) {
            chew();
            pushDown();
        }
    }

    public boolean pickUp() {
          /* attempt to pick up */
        if(!left.pickup()) {
            return false;
        }

        if(!right.pickup()) {
            left.pushDown();
            return false;
        }

        return true;
    }

    public void chew() {
    }

    public void pushDown() {
        right.pushDown();
        left.pushDown();
    }

    public void run() {
        for(int i = 0; i < bites; i++) {
            eat();
        }
    }

    public static void main(String[] args) {
        Chopstick left = new Chopstick("left");
        Chopstick right = new Chopstick(" right");

        Philosopher p = new Philosopher(left, right);
        p.run();
    }
}
