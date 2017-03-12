package edu.mum.Mathematical;

/**
 * Created by hungduong on 3/12/17.
 * Question: Design an algorithm to  nd the kth number such that the only prime factors are 3, 5, and 7.
 */
public class KthMagicNumber {
    public static int getKthMagicNumber(int k) {
        int[] magicNumber = new int[k];

        int last3 = 0, last5 = 0, last7 = 0;
        magicNumber[0] = 1;
        for(int i = 1; i < k; i++) {
            int nextMagicNumber = Math.min(Math.min(3*magicNumber[last3], 5*magicNumber[last5]), 7*magicNumber[7]);
            magicNumber[i] = nextMagicNumber;

            if(nextMagicNumber == 3*magicNumber[last3]) {
                last3++;
            }

            if(nextMagicNumber == 5*magicNumber[last5]) {
                last5++;
            }

            if(nextMagicNumber == 7*magicNumber[last7]) {
                last7++;
            }
        }

        return magicNumber[k - 1];
    }
}
