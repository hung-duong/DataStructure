package edu.mum.CS435.Lab03;

/**
 * Created by hungduong on 11/4/16.
 */
public class BubbleSort2 {
    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            boolean flag = false;

            for(int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;

                    flag = true;
                }
            }

            //If list is sorted
            if(!flag)
                break;

        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 1, 5, 10, 0, 3};

        BubbleSort2.bubbleSort(arr);

        for(Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
