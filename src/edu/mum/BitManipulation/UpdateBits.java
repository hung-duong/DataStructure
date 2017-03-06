package edu.mum.BitManipulation;

/**
 * Created by hungduong on 3/2/17.
 */
public class UpdateBits {
    /**
     * You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to set all bits between i and j
     * in N equal to M (e.g., M becomes a substring of N located at i and starting at j).
     * EXAMPLE:
     * Input: N = 10000000000, M = 10101, i = 2, j = 6
     * Output: N = 10001010100
     */
    public static int solution(int n, int m, int i, int j) {
        int max = ~0;  //All 1's     max = 1111 1111 1111 1111 1111 1111 1111 1111

        //1's through position j, then 0's
        int left = max - ((1 << j) - 1);  // left = 1111 1111 1111 1111 1111 1111 1100 0000

        //1's after position i
        int right = ((1 << i) - 1);  // right = 11

        //1's with 0's between i and j
        int mask = left | right;    // mask = 1111 1111 1111 1111 1111 1111 1100 0011

        //Clear i through j, then put m in there
        return (n & mask) | (m << i);
    }
}
