package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-12-04 22:41:14
 **/
public class LongestUnivaluePath_687 {

    class ReturnData {
        int max;
        int h;

        public ReturnData(int max, int h) {
            this.max = max;
            this.h = h;
        }
    }

    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longest(root);
        return max - 1;
    }

    private int longest(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int leftData = longest(node.left);
        int rightData = longest(node.right);
        int tmp = 1;
        int h = 1;
        if (node.left != null) {
            if (node.val == node.left.val) {
                tmp += leftData;
                h += leftData;
            }
        }
        if (node.right != null) {
            if (node.val == node.right.val) {
                tmp += rightData;
                if (h != 1) {
                    h = 1 + Math.max(leftData, rightData);
                } else {
                    h += rightData;
                }
            }
        }
        max = Math.max(max, tmp);
        return tmp;
    }
}
