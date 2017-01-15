package edu.mum.DynamicProgramming;

/**
 * Created by hungduong on 11/17/16.
 */
public class Knapsack {
    /*
     * val list benefits
     * wt list of weights
     * W maximum capacity
     * N number of items
     */
    public static int knapSack(int wt[], int val[], int n, int W) {
        int[][] V = new int[n + 1][W + 1];
        int[][] keep = new int[n + 1][W + 1];

        for(int i = 0; i <= n; i++) {
            for(int w = 0; w <= W; w++) {
                if(i == 0 || w == 0) {
                    V[i][w] = 0;
                } else if(w >= wt[i-1] && V[i-1][w] < val[i-1] + V[i-1][w - wt[i-1]]) {
                        V[i-1][w] = val[i-1] + V[i-1][w - wt[i-1]];
                        keep[i][w] = 1;
                } else {
                    V[i][w] = V[i-1][w];
                    keep[i][w] = 0;
                }
            }
        }

        int k = W;
        for(int i = 0; i<=n; i++) {
            if(keep[i][k] == 1) {
                System.out.print(i + " ");
                k = k - wt[i];
            }
        }

        return V[n][W];
    }

    public static void main(String[] args) {
        int[] val = {15, 12, 9, 16, 17};
        int[] wt = {2, 5, 3, 4, 6};
        int W = 12;

        int result = Knapsack.knapSack(wt, val, val.length, W);

        System.out.print(result);
    }
}
