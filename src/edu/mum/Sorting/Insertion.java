/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.Sorting;

/**
 *
 * @author hungduong
 * Complexity: O(n^2)
 */
public class Insertion {
    int[] a = {10, 2, 7, 5, 0, 6, 1};
    
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
