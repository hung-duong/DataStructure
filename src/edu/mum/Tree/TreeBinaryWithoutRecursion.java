/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.Tree;

import edu.mum.Util.TreeNode;

/**
 *
 * @author hungduong
 */
public class TreeBinaryWithoutRecursion {
    TreeNode root;
    
    void createTree(int[] a) {
        for (int i=0; i<a.length; i++) {
            insertNode(a[i]);
        }
    }
    
    void insertNode(int x) {
        TreeNode leaf = new TreeNode(x);
        
        if (root==null) {
            root = leaf;
        } else {
            TreeNode ni = findNodeInsert(x);
            
            if (ni != null) {
                if (ni.val > x) {
                    ni.left = leaf;
                } else {
                    ni.right = leaf;
                }
            }
        }
    }
    
    TreeNode findNodeInsert(int x) { 
        if (root==null)
            return null;
        
        TreeNode p = root;
        TreeNode q = p;
        
        while (p!=null) {
            q = p;
            if (p.val > x)
                p = p.left;
            else
                p = p.right;
        }
      
        return q;
    }
    
    // Dung stack de khu de quy
    TreeNode[] stack;
    int last;
    
    void init(){
        stack = new TreeNode[1000];
        last = -1;
    }
    
    void push(TreeNode node) {
        last++;
        stack[last] = node;
    }
    
    TreeNode pop() {
        last--;
        return stack[last+1];
    }
    
    boolean isEmpty() {
        return last == -1;
    }
    
    //Phuong phap khu de quy
    void preorderTraversalWithoutRecursion(TreeNode node) {
        TreeNode p = root;
        
        while(p.left!=null && p.right!=null) {
            push(p);
            if(p.left!=null)
                p = p.left;
            else
                p = p.right;
        }
        
    }
    
    void inorderTraversalWithoutRecursion(TreeNode node) {
        
    }
    
    void postorderTraversalWithoutRecursion(TreeNode node) {
        
    }
}
