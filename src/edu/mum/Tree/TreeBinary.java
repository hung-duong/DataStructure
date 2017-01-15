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
public class TreeBinary {
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
    
    //Phuong phap dung de quy
    void preorderTraversal(TreeNode node){
        if (node!=null) {
            System.out.print(node.val + "->");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }
    
    void inorderTraversal(TreeNode node) {
        if (node!=null) {
            inorderTraversal(node.left);
            System.out.print(node.val + "->");
            inorderTraversal(node.right);
        }
    }
    
    void postorderTraversal(TreeNode node) {
        if (node!=null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.val + "->");
        }
    }
}
