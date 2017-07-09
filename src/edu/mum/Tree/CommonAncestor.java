package edu.mum.Tree;

/**
 * Created by hungduong on 3/2/17.
 */
public class CommonAncestor {
    /**
     * Solution 1: There are 3 cases to find commom Ancestor of p and q
     * - p and q are both on the left side of the root node, so branch left to look for the common ancestor.
     * - p and q are both on the right side of the root node, so branch right to .....
     * - p and q are no longer on the same side, the common ancestor is root node.
     * <p>
     * What is the running time of this algorithm? One way of looking at this is to see how many times each node is touched.
     * Covers touches every child node, so we know that every single node in the tree must be touched at least once, and many
     * nodes are touched multiple times.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode findCommonAncestor01(TreeNode root, TreeNode p, TreeNode q) {
        //1. p and q are both on the left side of the root node, so branch left to look for the common ancestor
        if (covers(root.left, p) && covers(root.left, q))
            return findCommonAncestor01(root.left, p, q);

        //2. p and q are both on the right side of the root node, so branch right to .....
        if (covers(root.right, q) && covers(root.right, q))
            return findCommonAncestor01(root.right, p, q);

        //3. p and q are no longer on the same side, the common ancestor is root node.
        return root;
    }

    public boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;

        if (root.val == p.val) return true;

        return covers(root.left, p) || covers(root.right, p);
    }
}
