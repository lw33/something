package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2019-02-14 23:22:52
 **/
public class P783_MinimumDistanceBetweenBSTNodes {

    public int minDiffInBST(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList<>();
        boolean start = false;
        int pre = 0;
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (start) {
                    min = Math.min(root.val - pre, min);
                } else {
                    start = true;
                }
                pre = root.val;
                root = root.right;
            }
        }
        return min;
    }
}
