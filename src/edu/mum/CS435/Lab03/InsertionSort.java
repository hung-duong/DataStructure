package edu.mum.CS435.Lab03;

/**
 * Created by hungduong on 11/6/16.
 */
public class InsertionSort {
    int[] a = {10, 2, 7, 5, 0, 6, 1};

    //InsertionSort is stable sorting algorithm because algorithm handles the order of duplicates during inserting
    void insertionSort() {
        for(int i=1; i<a.length; i++) {
            int tmp = a[i];
            int j = i-1;
            while(j>=0 && tmp<a[j]) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = tmp;
        }
    }

    void insertionSortWithBinarySearching() {
        for(int i=1; i<a.length; i++) {
            int tmp = a[i];
            int inf = 0;
            int sup = i-1;
            do {
                int median = (inf + sup)/2;
                if(tmp<a[median])
                    sup = median-1;
                else
                    inf = median+1;
            } while (inf>sup);

            for(int j=inf; j<i-1; j++) {
                a[j+1] = a[j];
            }
            a[inf] = tmp;
        }
    }
}
