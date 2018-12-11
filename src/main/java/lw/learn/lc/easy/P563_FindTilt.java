package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-12-03 23:15:53
 **/
public class P563_FindTilt {

    int tilt;
    public int findTilt(TreeNode root) {

        find(root);
        return tilt;
    }

    public int find(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = find(node.left);
        int rightSum = find(node.right);
        tilt += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + node.val;
    }
}
