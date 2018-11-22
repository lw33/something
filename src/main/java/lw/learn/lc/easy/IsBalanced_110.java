package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-11-21 15:17:57
 * @tag easy
 **/
public class IsBalanced_110 {

    private Map<TreeNode, Integer> nodeHeight = new HashMap<>();

    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;
        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }
        int height = height(root.left) - height(root.right);
        height = Math.abs(height);
        if (height > 1)
            return false;
        return true;
    }



    private int height(TreeNode node) {
        if (node ==null)
            return 0;
        Integer height = nodeHeight.get(node);
        height = height == null ? Math.max(height(node.left), height(node.right)) + 1 : height;
        if (!nodeHeight.containsKey(node)) {
            nodeHeight.put(node, height);
        }
        return height;
    }

    // fastest
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return depth(root) != -1;
        }

        private int depth(TreeNode root) {
            if (root == null)
                return 0;

            int left = depth(root.left);
            if (left == -1)
                return -1;
            int right = depth(root.right);
            if (right == -1)
                return -1;

            if (Math.abs(left - right) > 1)
                return -1;
            return Math.max(left, right) + 1;
        }
    }
}
