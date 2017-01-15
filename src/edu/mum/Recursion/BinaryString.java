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
public class BinaryString {
    int N;
    int[] arr;
    
    BinaryString(int n){
        N = n;
        arr = new int[N];
        
        for(int i=0; i<3; i++) {
            arr[i] = 0;
        }
    }
    
    void listBinaryString(int i) {
        
        if (i<=0) return;
        
        for(int j=0; j<=1; j++) {
            arr[i-1] = j;
            if(i==N) {
                for(int k=0; k<N; k++)
                    System.out.print(arr[k]);
                System.out.print("\n");
            } else {
                listBinaryString(i+1);
            }
        }
    }
}
