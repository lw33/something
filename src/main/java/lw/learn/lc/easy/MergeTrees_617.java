package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-12-03 23:25:15
 **/
public class MergeTrees_617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        merge(t1, t2);
        return t1;
    }

    public void merge(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.val += node2.val;
        if (node1.left == null) {
            node1.left = node2.left;
        } else {
            merge(node1.left, node2.left);
        }
        if (node1.right == null) {
            node1.right = node2.right;
        } else {
            merge(node1.right, node2.right);
        }
    }
}
