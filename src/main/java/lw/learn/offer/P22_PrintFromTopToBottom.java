package lw.learn.offer;

import lw.learn.offer.util.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2018-10-01 21:40:27
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 **/
public class P22_PrintFromTopToBottom {


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            TreeNode poll = queue.poll();

            res.add(poll.val);

            if (poll.left != null) {
                queue.offer(poll.left);
            }

            if (poll.right != null) {
                queue.offer(poll.right);
            }


        }

        return res;
    }

    @Test
    public void test() {

    }
}
