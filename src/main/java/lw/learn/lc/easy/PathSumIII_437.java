package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-11-14 20:19:33
 **/
public class PathSumIII_437 {

    public int pathSum(TreeNode root, int sum) {

        if (root == null)
            return 0;

        if (sum == root.val)
            return 1;

        return pathSum(root.left, sum) + pathSum(root.left, sum - root.val) + pathSum(root.right, sum) + pathSum(root.right, sum - root.val);
    }
}
