package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-12-05 11:28:42
 **/
public class IncreasingBST_897 {

    public TreeNode increasingBST(TreeNode root) {

        if (root == null) {
            return null;
        }
        List<TreeNode> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root.left = null;
                if (nodes.size() > 0) {
                    nodes.get(nodes.size() - 1).right = root;
                }
                nodes.add(root);
                root = root.right;
            }
        }

        return nodes.get(0);
    }
}
