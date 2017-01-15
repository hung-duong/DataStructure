package edu.mum.CS435.Lab04;

import java.util.Random;

/**
 * Created by hungduong on 11/7/16.
 */
public class MergeSortPlus {
    public static void sort(int[] arr, int l, int r) {
        if(r - l <= 20) {
            insertionSort(arr);
        } else {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];

        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

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

        while (i < n1)
        {
            arr[k++] = L[i++];
        }

        while (j < n2)
        {
            arr[k++] = R[j++];
        }
    }

    public static void insertionSort(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            int tmp = arr[i];
            int j = i-1;
            while(j>=0 && tmp<arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = tmp;
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int[] arr = new int[2000];

        for(int i = 0; i<2000; i++) {
            arr[i] = new Random().nextInt(2000);
        }

        MergeSortPlus.sort(arr, 0, arr.length - 1);

        /*for(Integer i : arr) {
            System.out.print(i + " ");
        }*/

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
