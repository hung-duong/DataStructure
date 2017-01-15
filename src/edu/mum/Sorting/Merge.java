/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.Sorting;

/**
 *
 * @author hungduong
 * Complexity: O(nlog(n))
 */
public class Merge {
    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(int[] arr, int l, int r) {
        if(l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int [n1];
        int R[] = new int [n2];

        // Copy data to temp arrays
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];

        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i++];
            }
            else
            {
                arr[k] = R[j++];
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1)
        {
            arr[k++] = L[i++];
        }

        // Copy remaining elements of L[] if any
        while (j < n2)
        {
            arr[k++] = R[j++];
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 1, 5, 10, 0, 3};

        Merge.sort(arr, 0, arr.length - 1);

        for(Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
