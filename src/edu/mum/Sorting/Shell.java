/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.Sorting;

/**
 *
 * @author hungduong
 */
public class Shell {
    //Complexity: log(n^2)
    void shellSort(int[] a) {
        int h = a.length/2 - 1;
        while(h!=0) {
            for(int i=h; i<a.length; i++) {
                int tmp = a[i];
                int j = i-h-1;
                while(j>0) {
                    a[j+h-1] = a[j];
                    j = j-h-1;
                }
                a[j+h-1] = tmp;
            }
            h = h/2;
        }
    }
}
