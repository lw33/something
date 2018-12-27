package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-12-26 23:51:58
 **/
public class P108_ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return findRoot(nums, 0, nums.length);
    }

    private TreeNode findRoot(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = start + ((end - start) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = findRoot(nums, start, mid);
        root.right = findRoot(nums, mid + 1, end);
        return root;
    }


}
