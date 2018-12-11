package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-11-25 23:06:44
 **/
public class P404_SumOfLeftLeaves {

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public void sum(TreeNode head) {
        if (head == null)
            return;
        if (head.left != null && head.left.left == null && head.left.right == null) {
            sum += head.left.val;
            sum(head.right);
            return;
        }
        sum(head.left);
        sum(head.right);
    }
}
