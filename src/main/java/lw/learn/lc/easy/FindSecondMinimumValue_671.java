package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-04 11:21:23
 **/
public class FindSecondMinimumValue_671 {

    TreeNode leaf;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int val = root.val;

        while (root.val == val) {
            root = leaf(root);
            if (root == null) {
                if (leaf.val != val) {
                    return leaf.val;
                }
                return -1;
            }
            val = root.val;
            leaf.left = root.left;
            leaf.right = root.right;
            shifDown(leaf);
            root = leaf;
        }
        return leaf.val;
    }

    private TreeNode leaf(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            leaf = node;
            return null;
        }
        if (node.left != null) {
            node.left = leaf(node.left);
        } else {
            node.right = leaf(node.right);
        }
        return node;
    }

    private void shifDown(TreeNode node) {

        while (node.left != null || node.right != null) {
            TreeNode max = node.left;
            if (node.left == null) {
                max = node.right;
            } else if (node.right != null) {
                max = max.val > node.right.val ? node.right : max;
            }
            int tmp = node.val;
            node.val = max.val;
            max.val = tmp;
            node = max;
        }
    }
    
    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        System.out.println(this.findSecondMinimumValue(root));
    }
}
