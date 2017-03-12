package edu.mum.Sorting;

/**
 * Created by hungduong on 3/12/17.
 * Given a sorted array of strings which is interspersed with empty strings, write a meth- od to  nd the location of a
 * given string.
 * Example:  nd “ball” in [“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”] will return 4
 * Example:  nd “ballcar” in [“at”, “”, “”, “”, “”, “ball”, “car”, “”, “”, “dad”, “”, “”] will return -1
 */
public class SortedArrayEmptyString {
    public int search(String[] strings, int left, int right, String str) {
        if (left < right) {
            if (left <= right && strings[right] == "") {
                --right;
            }

            if (left > right) {
                return -1;
            }

            int mid = (left + right) / 2;
            while (strings[mid] == "") {
                mid++;
            }

            int r = strings[mid].compareTo(str);
            if (r == 0) {
                return mid;
            } else if (r < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public int search(String[] strings, String str) {
        if (strings == null || str == null)
            return -1;

        if (str == "") {
            for (int i = 0; i < strings.length; i++) {
                if (strings[i] == "")
                    return i;
            }
            return -1;
        }
        return search(strings, 0, strings.length - 1, str);
    }
}
