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
public class Bubble {
    int[] a = {10, 2, 7, 5, 0, 6, 1};
     
    void bubbleSort() {
        for(int i=1; i<a.length; i++) {
            for(int j=a.length; j<=i; j--) {
                if (a[j] < a[j-1]) {
                    int tmp = a[j];
                    a[j-1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
}
