package edu.mum.CS435.Lab02;

/**
 * Created by hungduong on 11/3/16.
 */
public class ZeroOne {
    public static int[] CountZeroOne(int[] arr) {
        if(arr.length == 0)
            return new int[]{0, 0};

        if(arr[1] == 1) {
            return new int[]{0, arr.length};
        }

        if(arr[arr.length - 1] == 0) {
            return new int[]{arr.length, 0};
        }

        int lo = 0;
        int hi = arr.length;
        int mid;

        while(lo < hi) {
            mid = lo + (hi - lo) / 2;

            if(arr[mid] == 1)
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        return new int[]{lo, arr.length - lo};
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        int[] res = ZeroOne.CountZeroOne(arr);

        for(Integer i : res)
            System.out.println(i);
    }
}
