package edu.mum.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by hungduong on 11/17/16.
 */
public class RodCutting {

    /* Returns the best obtainable price for a rod of length
       n and price[] as prices of different pieces */
    //Overlapping Subproblems: Top-Bottom Way
    public static int cutRod01(int prices[], int n) {
        if(n <= 0)
            return 0;

        int max_val = Integer.MIN_VALUE;

        // Recursively cut the rod in different pieces and
        // compare different configurations
        for(int i = 0; i < n; i++) {
            max_val = Math.max(max_val, prices[i] + cutRod01(prices, n - i - 1));
        }

        return max_val;
    }

    public static int cutRod02(int prices[], int n) {
        int val[] = new int[n+1];
        val[0] = 0;

        for(int i = 1; i <= n; i++) {
            int max_val = Integer.MIN_VALUE;

            for(int j = 0; j < i; j++)
                max_val = Math.max(max_val, prices[j] + val[i - j -1]);

            val[i] = max_val;
        }

        return val[n];
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};

       System.out.println("Maximum Obtainable Value is " + cutRod02(arr, arr.length));
    }
}
