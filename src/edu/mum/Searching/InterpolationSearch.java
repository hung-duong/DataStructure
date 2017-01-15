package edu.mum.Searching;

/**
 * Created by hungduong on 10/1/16.
 * Complexity: log(log(n))
 */
public class InterpolationSearch {
    public int interpolationSearchSolution(int[] arr, int key) {
        if(arr == null || arr.length == 0) return -1;

        int low = 0;
        int high = arr.length -1;

        while( low < high) {
            int mid  = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);

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
