package lw.learn.lc.medium;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-14 11:56:48
 **/
public class P144_PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);

    }

    public List<Integer> preorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (pop.right != null)
                stack.push(pop.right);
            if (pop.left != null)
                stack.push(pop.left);
        }
        return res;
    }


}
