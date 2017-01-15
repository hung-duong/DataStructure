package edu.mum.CS435.Lab02;

/**
 * Created by hungduong on 11/2/16.
 */
public class MergeArray {
    public static int[] merge(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        int[] arr = new int[len1 + len2];

        int i = 0, j = 0, k = 0;
        while (i < len1 || j < len2) {
            if(i < len1 && j < len2) {
                arr[k] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
            } else if (i < len1) {
                arr[k] = arr1[i++];
            } else {
                arr[k] = arr2[j++];
            }

            k++;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5, 8, 17};
        int[] arr2 = {2, 4, 8, 11, 13, 21, 23, 25};

        int[] arr = MergeArray.merge(arr1, arr2);

        for(Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
