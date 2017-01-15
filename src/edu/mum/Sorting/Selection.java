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
public class Selection {
    
    private static int[] a = {10, 2, 7, 5, 0, 6, 1};
    
    public static void selectionSort() {
        for (int i=0; i<a.length-1; i++) {
            int jmin = i;
            
            for (int j=i+1; j<a.length; j++) {
                if (a[j] < a[jmin]) {
                    jmin = j;
                }
            }

            if (jmin!=i) {
                int tmp = a[i];
                a[i] = a[jmin];
                a[jmin] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Selection.selectionSort();

        for(Integer i : a) {
            System.out.print(i + " ");
        }
    }
}
