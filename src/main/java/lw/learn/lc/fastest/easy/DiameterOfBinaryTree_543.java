package lw.learn.lc.fastest.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-12-03 22:04:28
 **/
// TODO: 2018/12/3 666
public class DiameterOfBinaryTree_543 {
    class Solution {
        int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            findMax(root);
            return max;
        }
        private int findMax(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = findMax(root.left)+1;
            int right = findMax(root.right)+1;
            max = Math.max(left+right-2, max);
            return Math.max(left, right);
        }
    }
}
