package lw.learn.lc.medium;

import lw.learn.lc.ds.TreeNode;
import org.junit.Test;

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

            if (root.left == null) {
                TreeNode rightNode = root.right;
                root.right = null;
                root = rightNode;
            } else if (root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                root = leftNode;
            } else {
                TreeNode min = min(root.right);
                root.right = removeMin(root.right);
                min.left = root.left;
                min.right = root.right;
                root.left = null;
                root.right = null;
                root = min;
            }
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

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        this.deleteNode(root, 3);
        System.out.println();
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
