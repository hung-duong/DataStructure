package edu.mum.DynamicProgramming;

/**
 * Created by hungduong on 11/18/16.
 */
public class BinomialCoefficient {
    public static int binomial(int n, int k) {
        int[][] C = new int[n + 1][k + 1];

        for(int i = 0; i <= n; i++) {
            int min =  Math.min(i, k);
            for(int j = 0; j <= min; j++) {
                if(j == 0 || j == i)
                    C[i][j] = 1;
                else
                    C[i][j] = C[i-1][j] + C[i-1][j-1];
            }
        }

        return C[n][k];
    }

    public static void main(String[] args) {
        int coeff = BinomialCoefficient.binomial(5, 2);
        System.out.print(coeff);
    }
}
