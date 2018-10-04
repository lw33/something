package lw.learn.offer;

import lw.learn.offer.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lw
 * @Date 2018-10-03 21:18:41
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 **/
public class P60_PrintTreeEveryLevel {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {


        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (pRoot == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int nextLevel = 0;
        int curLevel = 1;
        ArrayList<Integer> nodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode peek = queue.peek();
            if (peek.left != null) {
                queue.offer(peek.left);
                nextLevel++;
            }
            if (peek.right != null) {
                queue.offer(peek.right);
                nextLevel++;
            }
            nodes.add(queue.poll().val);
            curLevel--;
            if (curLevel == 0) {
                res.add(nodes);
                nodes = new ArrayList<>();
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return res;
    }

}
