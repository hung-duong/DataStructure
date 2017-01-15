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
public class Collatz {
    
    //Phuong phap de quy
    void solve(int n) {
        if (n==1) 
            System.out.print(n);
        else 
            if (n%2==0) {
                solve(n/2);
                System.out.print("*2");
            }
            else{
                solve(n*3+1);
                System.out.print("*3+1");
            }
    }
     
    //Phuong Phap khu de quy
    int[] stack;
    int last;
    
    void init() {
        stack = new int[100];
        last = -1;
    }
    
    void push(int i) {
        last++;
        stack[last] = i;
    }
    
    int pop() {
        last--;
        return stack[last+1];
    }
    
    boolean isEmpty() {
        return last == -1;
    }
    
    void solveWithoutRecusion(int n) {
        if (n<=0) return;
        
        while(n!=1) {
            if (n%2==0) {
                push(n/2);
                n = n/2;
            }  
            else {
                push(n*3+1);
                n = n*3+1;
            }
        }
        
        while(!isEmpty()) {
            int i = pop();
            System.out.print("<-" + i);
        }
    }
}
