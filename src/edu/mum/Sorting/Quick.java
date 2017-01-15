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
public class Quick {
    int[] a = {10, 2, 7, 5, 0, 6, 1};

    //Complexity : nlog(n)
    void quickSort(int l, int h) {
        if (l>=h) return;
        
        int pivot = (int)(Math.random()*(h-l+1) + l);
        int i = l; 
        int j = h;
        
        do {
            if(a[i] < pivot) i++;
            if(a[j] > pivot) j--;
            
            if(i<=j) {
                if(i<j) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
                i++;
                j--;
            } 
        } while(i>j);
        
        quickSort(l,j);
        quickSort(i, h);
    }
    
    void quickSortImproved(int l, int h) {
        do {
            if (l>=h) return;
        
            int pivot = (int)(Math.random()*(h-l+1) + l);
            int i = l; 
            int j = h;
        
            do {
                if(a[i] < pivot) i++;
                if(a[j] > pivot) j--;

                if(i<=j) {
                    if(i<j) {
                        int tmp = a[i];
                        a[i] = a[j];
                        a[j] = tmp;
                    }
                    i++;
                    j--;
                } 
            } while(i>j);
            
            if ((j-l)<(h-i)) {
                quickSortImproved(l, j);
                l = i;
            } else {
                quickSortImproved(i, h);
                h = j;
            }
        }while(false);
    }
}
