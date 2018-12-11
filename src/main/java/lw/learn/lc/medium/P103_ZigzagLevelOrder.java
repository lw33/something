package lw.learn.lc.medium;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-12-08 19:10:45
 **/
public class P103_ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> nodes = new ArrayList<>();
        stack1.push(root);
        boolean flag = true;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (flag) {
                root = stack1.pop();
                if (root.left != null) {
                    stack2.push(root.left);
                }
                if (root.right != null) {
                    stack2.push(root.right);
                }
            } else {
                root = stack2.pop();
                if (root.right != null) {
                    stack1.push(root.right);
                }
                if (root.left != null) {
                    stack1.push(root.left);
                }
            }
            nodes.add(root.val);
            if (flag && stack1.isEmpty()) {
                flag = false;
                res.add(new ArrayList<>(nodes));
                nodes.clear();
            } else if (!flag && stack2.isEmpty()) {
                flag = true;
                res.add(new ArrayList<>(nodes));
                nodes.clear();
            }
        }
        return res;
    }

}
