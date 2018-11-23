package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-11-23 12:39:06
 * @tag easy
 **/
public class MinDepth_111 {

    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        minDepth(root, 1);
        return min;
    }

    private void minDepth(TreeNode root, int sum) {

        if (root.left == null && root.right == null) {
            min = min > sum ? sum : min;
            return;
        }
        if (root.left != null)
            minDepth(root.left, sum + 1);
        if (root.right != null)
            minDepth(root.right, sum + 1);
    }
}
