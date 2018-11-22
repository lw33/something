package lw.learn.lc.medium;

import lw.learn.lc.ds.TreeNode;

import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-11-21 16:03:42
 * @tag medium
 **/
public class IsValidBST_98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val < pre)
                    return false;
                pre = root.val;
                root = root.right;
            }
        }
        return true;
    }
}
