package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2019-01-14 21:30:39
 **/
public class P965_UnivaluedBinaryTree {

    // FIXME 2019/1/14  morris
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return preOrder(root, root.val);
    }

    public boolean preOrder(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        if (node.val != val) {
            return false;
        }
        return preOrder(node.left, val) && preOrder(node.right, val);
    }
}
