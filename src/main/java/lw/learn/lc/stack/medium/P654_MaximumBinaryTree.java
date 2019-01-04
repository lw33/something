package lw.learn.lc.stack.medium;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2019-01-04 14:56:18
 * @tag medium
 **/
public class P654_MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        return root;
    }
}
