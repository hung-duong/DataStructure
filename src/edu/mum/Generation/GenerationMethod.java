/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.Generation;

/**
 *
 * @author hungduong
 */
public class GenerationMethod {
    /* 
     * Generate all N bit binary numbers 
     */
    
    void generateBinaryString(int N) {
        
        if (N<=0) return;
        
        int[] arr = new int[N];
        
        for(int i=0; i<N; i++) {
            arr[i] = 0;
        }
        
        boolean run = true;
        do {
            for(int i=0; i<N; i++)
                System.out.print(arr[i]);
            System.out.print("\n");
            
            int k = N-1;
            while(k>-1 && arr[k]==1) {
                k--;
            }
            
            if(k>-1){
                arr[k] = 1;
                for(int i=k+1; i<N; i++) {
                    arr[i] = 0;
                }
            } else {
                run = false;
            }
        } while(run);
    }
    
    /*
     * List sublist of K elements of N elemnts
     */
    static void combinationKofN(int N, int K) {
        
        if (N<=0 || K<=0) return;
        
        if (K>N) return;
        
        int[] arr = new int[K];
        
        for (int i=0; i<K; i++) {
            arr[i] = i+1;
        }
        
        boolean run = true;
        
        do {
            for(int i=0; i<K; i++)
                System.out.print(arr[i]);
            System.out.print("\n");
            
            int j = K-1;
            while(j>-1 && arr[j]==N-K+j+1) {
                j--;
            }
            
            if(j>-1) {
                arr[j]++;
                for (int i=j+1; i<K; i++) {
                    arr[i] = arr[i-1] + 1;
                }
            } else {
                run = false;
            }
        } while(run);
    }
    
    /*
     * List all string permuatation
     */
    void permutation(int N) {
        if (N<=0) return;
        
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }
        
        boolean run = true;
        do {
            for(int i=0; i<N; i++)
                System.out.print(arr[i]);
            System.out.print("\n");
            
            int k = N-2;
            while(k>-1 && arr[k]>arr[k+1]) {
                k--;
            }
            
            if(k>-1) {
                int j = N-1;
                while(arr[j] < arr[k]) {
                    j--;
                }
                
                //swap arr[j] and arr[k]
                int tmp = arr[k];
                arr[k] = arr[j];
                arr[j] = tmp;
                
                int a = k+1;
                int b = N-1;
                while (a<b) {
                    tmp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = tmp;
                    
                    a++;
                    b--;
                }
            } else {
                run = false;
            }      
        } while(run);
    }

    public static void main(String[] args) {
        combinationKofN(3, 0);
    }
}
