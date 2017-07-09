package edu.mum.Recursion;

/**
 * Created by hungduong on 5/10/17.
 * Write a recursive function to multiply two positive integers without using the * operator (or / operator).
 * You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
 */
public class RecursiveMultiply {
    //O(log smaller)
    public static int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;

        return minProductHelper(smaller, bigger);
    }

    public static int minProductHelper(int smaller, int bigger) {
        if(smaller == 0) {
            return 0;
        } else if(smaller == 1) {
            return bigger;
        }

        int s = smaller >> 1;
        int half = minProductHelper(s, bigger);

        if(smaller % 2 == 1) {
            return half + half + bigger;
        } else {
            return half + half;
        }
    }
}
