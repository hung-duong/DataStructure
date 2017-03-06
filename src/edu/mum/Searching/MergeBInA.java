package edu.mum.Searching;

/**
 * Created by hungduong on 3/6/17.
 */
public class MergeBInA {
    /**
     * You are given two sorted arrays, A and B, and A has a large enough bu er at the end to hold B.
     * Write a method to merge B into A in sorted order.
     */
    public static void merge(int[] A, int[] B) {
        int k = A.length + B.length - 1;
        int n = A.length - 1;
        int m = B.length - 1;

        while(n > -1 && m > -1) {
            if(A[n] > B[m]) {
                A[k--] = A[n--];
             } else {
                A[k--] = B[m--];
            }
        }

        while(m > -1) {
            A[k--] = B[m--];
        }
    }
}
