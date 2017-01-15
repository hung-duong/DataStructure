/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.Searching;

/**
 *
 * @author hungduong
 */
public class BinarySearch {
    public int binarySearchSolution(int[] arr, int key) {
        if(arr == null || arr.length == 0) return -1;

        int low = 0;
        int high = arr.length -1;

        while( low < high) {
            int mid  = low + (high - low) / 2;

            if(arr[mid] < key) {
                low = mid + 1;
            } else if(arr[mid] > key) {
                high = high -1;
            } else {
                return mid;
            }
        }

        if(key == arr[low]) {
            return low;
        } else {
            return -1;
        }
    }
}
