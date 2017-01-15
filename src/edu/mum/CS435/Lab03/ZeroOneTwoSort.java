package edu.mum.CS435.Lab03;

/**
 * Created by hungduong on 11/5/16.
 */
public class ZeroOneTwoSort {
    public static void sortZeroOneTwo(int[] arr) {
        if(arr.length == 0)
            return;

        int zeros = 0, ones = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                zeros++;
            else if (arr[i] == 1)
                ones++;

        }

        for (int i = 0; i < arr.length; i++) {
            if (i < zeros) {
                arr[i] = 0;
            } else if (i < ones + zeros) {
                arr[i] = 1;
            } else {
                arr[i] = 2;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 2, 0, 0, 1, 0, 2};

        ZeroOneTwoSort.sortZeroOneTwo(arr);

        for(Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
