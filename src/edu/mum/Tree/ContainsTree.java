package edu.mum.Tree;

/**
 * Created by hungduong on 3/2/17.
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hun- dreds of nodes.
 * Create an algorithm to decide if T2 is a subtree of T1.
 */
public class ContainsTree {
    public boolean contrainsTree(TreeNode T1, TreeNode T2) {
        if(T2 == null) return true; //The empty tree is always a subtree
        else return subTree(T1, T2);
    }

    public boolean subTree(TreeNode T1, TreeNode T2) {
        // big tree empty & subtree still not found
        if(T1 == null)
            return false;

        if(T1.val == T2.val) {
            if(matchTree(T1, T2))
                return true;
        }

        return subTree(T1.left, T2) || subTree(T1.right, T2);
    }

    public boolean matchTree(TreeNode T1, TreeNode T2) {
        if(T1 == null && T2 == null)
            return true;

        if(T1 == null || T2 == null)
            return false;

        if(T1.val != T2.val)
            return false;

        return matchTree(T1.left, T2.left) || matchTree(T1.right, T2.right);
    }
}
