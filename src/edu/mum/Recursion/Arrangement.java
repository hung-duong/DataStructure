/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.Recursion;

/**
 *
 * @author hungduong
 */
public class Arrangement {
    int n,k;
    int[] x;
    boolean[] c;
    
    Arrangement(int n, int k) {
        this.n = n;
        this.k = k;
        x = new int[n];
        c = new boolean[n];
        
        for(int j=0; j<n; j++) {
            c[j] = true;
        }
    }
    
    void listArrangementKofN(int i) {
        for(int j=0; j<n; j++) {
            if(c[j]) {
                x[i-1] = j+1;
                if(i==k) {
                    for(int f=0; f<k; f++)
                        System.out.print(x[f]);
                    System.out.print("\n");
                } else {
                    c[j] = false;
                    listArrangementKofN(i+1);
                    c[j] = true;
                }
            }
        }
    }
}
