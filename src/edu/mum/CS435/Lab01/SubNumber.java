package edu.mum.CS435.Lab01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hungduong on 10/31/16.
 * Formulate your own procedure for solving the SubsetSum Problem. Think of it as a Java method subsetsum that accepts as input S, k,
 * and outputs a subset T of S with the property that the sum of the si in T is k if such a T exists , or null if no such T can be found.
 */
public class SubNumber {
    //Use Brute Force Solution
    private static List<List<Integer>> subs = new ArrayList<>();

    public static List<List<Integer>>  subSetSum(int[] nums, int target) {
        Arrays.sort(nums);
        String str = null;
        subsetsumHelper(nums, target, str, 0, nums.length - 1);

        return subs;
    }

    public static void subsetsumHelper(int[] nums, int target, String str, int lo, int hi) {
        int sum = 0;
        List<Integer> ls = new ArrayList<>();

        if(str != null) {
            ls.clear();

            String[] arrStr = str.split(",");
            for(String s : arrStr) {
                int n = Integer.parseInt(s);
                sum += n;
                ls.add(n);
            }
        }

        if(str != null && sum == target) {
            if(subs.contains(ls)) {
                return;
            }

            subs.add(ls);

            return;
        }

        if(str == null) {
            for(int index = hi; index >= 0; index--) {
                if(nums[index] == target || nums[0] + nums[index] <= target) {
                    subsetsumHelper(nums, target, nums[index] + "", 0, index - 1);
                }
            }
        } else {
            for(int index = lo; index <= hi; index++) {
                if(sum + nums[index] <= target) {
                    subsetsumHelper(nums, target, str + "," + nums[index], index + 1, hi);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {3, 2, 6, 7, 14, 28, 31};

        List<List<Integer>> ls = subSetSum(input, 88);

        for(List<Integer> ss : ls) {
            List<Integer> lss = (List) ss;
            for(int l : lss) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }
}
