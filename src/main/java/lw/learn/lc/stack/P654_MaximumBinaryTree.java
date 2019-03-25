package lw.learn.lc.stack;

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
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        } else if (start > end) {
            return null;
        }

        int maxIndex = maxIndex(nums, start, end);
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = dfs(nums, start, maxIndex - 1);
        node.right = dfs(nums, maxIndex + 1, end);
        return node;
    }

    private static int maxIndex(int[] arr, int start, int end) {
        int max = arr[start];
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
