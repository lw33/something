package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-06 21:29:21
 **/
public class P530_MinimumAbsoluteDifferenceInBST {


    public int getMinimumDifference(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList<>();
        int pre = Integer.MIN_VALUE >> 3;
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                min = Math.min(root.val - pre, min);
                pre = root.val;
                root = root.right;
            }
        }
        return min;
       /* List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int pre = list.get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - pre);
        }
        return min;*/
    }

    private void inOrder(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right, res);

    }

}
