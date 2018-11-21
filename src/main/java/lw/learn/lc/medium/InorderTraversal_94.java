package lw.learn.lc.medium;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-11-21 11:58:59
 * @tag medium
 **/
public class InorderTraversal_94 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        //inOrder(root, res);
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;

            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }

        return res;
    }


    private void inOrder(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right, res);

    }
}
