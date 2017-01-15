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
public class Combination {
    int N, K;
    int[] arr;
    
    Combination(int n, int k) {
        N = n;
        K = k;
        
        arr = new int[K];
        for(int j=0; j<K; j++) {
            arr[j] = 0;
        }
    }
    
    void listCombinationKofN(int i){
        if(i<=0) return;
        
        for(int j=arr[i-1]+1; j<=N-K+i; j++) {
            arr[i-1] = j;
            
            if(i==K) {
                for(int f=0; f<K; f++)
                    System.out.print(arr[f]);
                System.out.print("\n");
            } else {
                listCombinationKofN(i+1);
            }
        }
    }
}
