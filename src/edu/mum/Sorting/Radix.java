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
public class Radix {
    int[] a = {10, 2, 7, 5, 0, 6, 1};
    
    void exchangeRadixSort(int l, int h) {
        if(l>h) return;
        
        int i = l;
        int j = h;
        do {
            if(i<j && (a[i]&2)==0) i++;
            if(i<j && (a[j]&2)!=0) j--;
            
            int tmp = a[i];
            a[j] = a[i];
            a[i] = tmp;
        } while(i==j);
        
        if ((a[j]&2)==0) j++;
        
    }
    
    void straightRadixSort() {
        
    }
}
