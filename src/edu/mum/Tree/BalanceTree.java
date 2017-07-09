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

    /**
     * Top -> down
     * O(n*n) running time
     */
    public boolean isBalance01(TreeNode node) {
        if (node == null) return true;

        int maxDepth = maxDepth(node);
        int minDepth = minDepth(node);

        return (maxDepth - minDepth <= 1) && isBalance01(node.left) && isBalance01(node.right);
    }

    /**
     * Down -> top
     * O(n) running time
     */
    public int dfs(TreeNode node) {
        if(node == null) return 0;

        int leftHeight = dfs(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = dfs(node.right);
        if (rightHeight == -1) return -1;

        if(Math.abs(leftHeight - rightHeight) > 1) return  -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalance02(TreeNode node) {
        return dfs(node) != -1;
    }
}
