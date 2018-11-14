package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-11-14 19:09:28
 **/
public class HasPathSum_112 {

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null)
            return false;

        if (sum == root.val && root.left == null && root.right == null)
            return true;

        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);
    }
}
