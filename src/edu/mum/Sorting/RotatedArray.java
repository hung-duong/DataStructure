package edu.mum.Sorting;

/**
 * Created by hungduong on 3/11/17.
 * Questions: Given a sorted array of n integers that has been rotated an unknown number of times, give an O(log n) algorithm that
 * nds an element in the array. You may assume that the array was originally sorted in increasing order.
 */
public class RotatedArray {
    public static int search(int[] a, int l, int r, int x) {
        while(l <= r) {
            int m = (l + r) / 2;

            if(a[m] == x) {
                return m;
            } else if(a[l] <= a[m]) {
                if(x > a[m]) {
                    l = m + 1;
                } else if(x >= a[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if(x < a[m]) {
                r = m - 1;
            } else if(x <= a[r]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    //What about duplicates? You may observe that the above function doesn’t give you an efficient result in case of
    // duplicate elements.
    // However, if your array has duplicate entries then we can’t do better than O(n) which is as good as linear search.

    public static void main(String[] args) {
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10};
        int i = search(arr, 0, 11, 4);
    }
}
