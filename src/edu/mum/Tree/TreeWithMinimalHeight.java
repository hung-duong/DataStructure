package edu.mum.Tree;

/**
 * Created by hungduong on 3/1/17.
 */
public class TreeWithMinimalHeight {

    public TreeNode addNodes(int[] arr, int start, int end) {
        if(start < end)
            return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = addNodes(arr, start, mid - 1);
        node.right = addNodes(arr, mid + 1, end);

        return node;
    }

    public TreeNode createMinimalBST(int[] arr) {
        return addNodes(arr, 0, arr.length - 1);
    }
}
