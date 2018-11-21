package lw.learn.lc.hard;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-11-21 11:54:11
 * @tag hard
 **/
public class PostorderTraversal_145 {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        //inOrder(root, res);
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        while (!stack1.isEmpty()) {
            TreeNode pop = stack1.pop();
            stack2.push(pop);
            if (pop.left != null)
                stack1.push(pop.left);
            if (pop.right != null)
                stack1.push(pop.right);
        }
        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }
        return res;
    }

    public void inOrder(TreeNode node, List<Integer> res) {
        if(node == null)
            return;
        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right, res);
    }
}
