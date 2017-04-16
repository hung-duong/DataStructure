package edu.mum.Tree;

import edu.mum.Util.TreeNode;

/**
 * Created by hungduong on 4/15/17.
 */
public class RedBlackTree {
    private TreeNode root;

    public RedBlackTree() {}

    protected TreeNode BSTInsert(TreeNode root, TreeNode node) {
        if(root == null)
            return node;

        if(node.data < root.data) {
            root.left = BSTInsert(root.left, node);
            root.left.parent = root;
        } else if (node.data > root.data) {
            root.right = BSTInsert(root.right, node);
            root.right.parent = root;
        }

        return root;
    }

    protected void rotateLeft(TreeNode root, TreeNode node) {

    }

    protected void rotateRight(TreeNode root, TreeNode node) {

    }

    // This function fixes violations caused by BST insertion
    protected void balance(TreeNode root, TreeNode node) {

    }

    // Function to insert a new node with given data
    public void insert(int data) {
        TreeNode node = new TreeNode(data);

        root = BSTInsert(root, node);
        balance(root, node);
    }


}
