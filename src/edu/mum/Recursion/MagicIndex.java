package edu.mum.Recursion;

/**
 * Created by hungduong on 5/10/17.
 * Question: A magic index in an array A[ 1.•.n-1] is defined to be an index such that A[ i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 */
public class MagicIndex {
    //Solution 1: Magic slow O(n)
    public static int magicSlow(int[] array) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == i)
                return i;
        }

        return -1;
    }

    //Solution2: O(logn) binary search tree but have some customize
    public static int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    public static int magicFast(int[] array, int start, int end) {
        if(start > end) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if(midIndex == midValue) return midIndex;

        /* Search left */
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicFast(array, start, leftIndex);
        if(left >= 0)
            return left;

        /* Search right */
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicFast(array, rightIndex, end);

        return right;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};

        System.out.print(magicFast(nums));
    }
}
