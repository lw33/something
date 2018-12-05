package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-12-05 23:05:28
 **/
public class TrimBST_669 {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        return inOrder(root, L, R);
    }

    public TreeNode inOrder(TreeNode node, int l, int r) {
        if (node == null) {
            return null;
        }
        if (node.val < l) {
            return inOrder(node.right, l, r);
        }
        if (node.val > r) {
            return inOrder(node.left, l, r);
        }

        node.left = inOrder(node.left, l, r);
        node.right = inOrder(node.right, l, r);
        return node;
    }
}
