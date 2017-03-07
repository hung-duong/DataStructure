package edu.mum.Sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by hungduong on 3/6/17.
 */
public class AnagramComparator implements Comparator<String> {
    public String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    @Override
    public int compare(String str1, String str2) {
        return sort(str1).compareTo(sort(str2));
    }

    public static void main(String[] args) {
        String[] array = {"hello", "olleh", "bye", "bey"};
        Arrays.sort(array, new AnagramComparator());

        for(String str : array)
            System.out.print(str);
    }
}
