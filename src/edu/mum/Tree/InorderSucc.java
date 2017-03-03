package edu.mum.Tree;

/**
 * Created by hungduong on 3/2/17.
 * Write an algorithm to  nd the ‘next’ node (e.g., in-order successor) of a given node in a binary search tree where each
 * node has a link to its parent.
 *
 * Solution: On an in-order traversal, we visit X.left, then X, then X.right.
 * 1. If X has a right child, then the successor must be on the right side of X (because of the order in which we visit nodes).
 * Specically, the left-most child must be the  rst node visited in that subtree.
 * 2. Else, we go to X’s parent (call it P).
 *      If X was a left child (P.left = X), then P is the successor of X
 *      If X was a right child (P.right = X), then we have fully visited P, so we call successor(P).
 */
public class InorderSucc {
    class TreeNodeHasParrent {
        public int val;
        public TreeNodeHasParrent parrent;
        public TreeNodeHasParrent left;
        public TreeNodeHasParrent right;
        public TreeNodeHasParrent(int x, TreeNodeHasParrent parrent) {
            this.val = x;
            this.parrent = parrent;
            this.left = this.right = null;
        }
    }

    public TreeNodeHasParrent successor(TreeNodeHasParrent node) {
        if(node != null) {
            TreeNodeHasParrent p;
            // We consider a node which have the right child because the successor of o node is always is right
            // Found right children -> return 1st inorder node on right
            if(node.parrent == null || node.right != null) {
                p = leftMostChild(node.right);
            } else {
                //If the current node have no the child then go up the parent to find the successor
                //      If X was a left child (P.left = X), then P is the successor of X
                //      If X was a right child (P.right = X), then we have fully visited P, so we call successor(P).
                p = node.parrent;
                while(p != null) {
                    if(p.left == node)
                        break;
                    node = p;
                    p = node.parrent;
                }
            }

            return p;
        }

        return null;
    }

    public TreeNodeHasParrent leftMostChild(TreeNodeHasParrent node) {
        while(node.left != null)
            node = node.left;

        return node;
    }
}
