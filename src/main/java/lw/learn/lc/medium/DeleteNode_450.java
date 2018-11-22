package lw.learn.lc.medium;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-11-22 22:36:50
 **/
public class DeleteNode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null)
            return null;

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            TreeNode min = null;
            if (root.left != null) {
                min = min(root.left);
                root.left = removeMin(root.left);
            } else if (root.right != null) {
                min = min(root.right);
                root.right = removeMin(root.right);
            } else {
                return null;
            }
            min.left = root.left;
            min.right = root.right;
            root.left = null;
            root.right = null;
            root = min;
        }
        return root;
    }


    private TreeNode min(TreeNode node) {

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode right = node.right;
            node.right = null;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public TreeNode getLeft(TreeNode node) {
        if (node == null)
            return null;

        while (node.left != null)
            node = node.left;

        return node;
    }

    public TreeNode getRight(TreeNode node) {
        if (node == null)
            return null;
        while (node.right != null)
            node = node.right;
        return node;
    }
}
