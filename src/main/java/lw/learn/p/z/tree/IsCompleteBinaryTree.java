package lw.learn.p.z.tree;

import lw.learn.lc.ds.TreeNode;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2018-11-21 16:20:39
 **/
public class IsCompleteBinaryTree {
    public boolean isCBT(TreeNode head) {
        boolean leaf = false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if ((leaf && (left != null || right != null)) || (left != null && right == null))
                return false;
            if (left != null)
                queue.push(left);
            if (right != null)
                queue.push(right);
            else
                leaf = true;
        }
        return true;
    }
}
