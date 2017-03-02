package edu.mum.Tree;

/**
 * Created by hungduong on 3/1/17.
 */
public class BalanceTree {
    public int maxDepth(TreeNode node) {
        if(node == null)
            return 0;

        int max = 1 + Math.max(maxDepth(node.left), maxDepth(node.right));

        return max;
    }

    public int minDepth(TreeNode node) {
        if(node == null)
            return 0;

        int min = 1 + Math.min(maxDepth(node.left), maxDepth(node.right));

        return min;
    }

    public boolean isBalance(TreeNode node) {
        int maxDepth = maxDepth(node);
        int minDepth = minDepth(node);

        return (maxDepth - minDepth <= 1);
    }
}
