/*
 * Cho mot so nguyen duong n<=30, hay tim tat ca cac cach phan tich so n thanh tong cua cac so nguyen duong
 * cac cach phan tich la hoan vi cua nhau chi tinh la 1 cach.
 */
package edu.mum.Recursion;

/**
 *
 * @author hungduong
 */
public class Analyses {
    int n;
    int[] x, t;
    
    Analyses(int n) {
        this.n = n;
        x = new int[n+1];
        t = new int[n+1];
        x[0] = 1;
        t[0] = 0;
    }
    
    void listAnalyse(int i) {
        for(int j=x[i-1]; j<=(n-t[i-1])/2; j++) {
            x[i] = j;
            t[i] = t[i-1] + j;
            listAnalyse(i+1);
        }
        x[i] = n - t[i-1];
        
        for(int j=1; j<=i; j++)
            System.out.print(x[j] + "+");
        System.out.print("\n");
    }
}
