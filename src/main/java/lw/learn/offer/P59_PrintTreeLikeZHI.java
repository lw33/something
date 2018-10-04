package lw.learn.offer;

import lw.learn.offer.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2018-10-03 21:15:07
 *
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 **/
public class P59_PrintTreeLikeZHI {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }

        LinkedList<TreeNode> l2rStack = new LinkedList<>();
        LinkedList<TreeNode> r2lStack = new LinkedList<>();

        boolean l2r = true;

        l2rStack.push(pRoot);
        ArrayList<Integer> nodes = new ArrayList<>();
        while (!l2rStack.isEmpty() || !r2lStack.isEmpty()) {
            if (l2r) {
                if (l2rStack.isEmpty()) {
                    l2r = false;
                    res.add(nodes);
                    nodes = new ArrayList<>();
                    continue;
                }
                TreeNode pop = l2rStack.pop();
                nodes.add(pop.val);
                if (pop.left != null) {
                    r2lStack.push(pop.left);
                }
                if (pop.right != null) {
                    r2lStack.push(pop.right);
                }
            } else {
                if (r2lStack.isEmpty()) {
                    l2r = true;
                    res.add(nodes);
                    nodes = new ArrayList<>();
                    continue;
                }
                TreeNode pop = r2lStack.pop();
                nodes.add(pop.val);
                if (pop.right != null) {
                    l2rStack.push(pop.right);
                }
                if (pop.left != null) {
                    l2rStack.push(pop.left);
                }
            }
        }
        res.add(nodes);
        return res;
    }
}
