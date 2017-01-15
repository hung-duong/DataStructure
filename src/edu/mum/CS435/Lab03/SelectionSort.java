package edu.mum.CS435.Lab03;

/**
 * Created by hungduong on 11/6/16.
 */
public class SelectionSort {
    public static void SelectionSort(int[] arr){
        int len = arr.length;

        for(int i=0; i < len; i++) {
            int nextMinPos = minpos(arr, i, len - 1);

            if(nextMinPos != i) {
                int tmp = arr[i];
                arr[i] = arr[nextMinPos];
                arr[nextMinPos] = tmp;
            }
        }
    }

    public static int minpos(int[] arr, int bottom, int top) {
        int m = arr[bottom];
        int index = bottom;

        for(int i = bottom + 1; i <= top; i++) {
            if(arr[i] < m) {
                m = arr[i];
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 1, 5, 10, 0, 3};

        SelectionSort.SelectionSort(arr);

        for(Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
