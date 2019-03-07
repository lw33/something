package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2019-03-04 22:10:08
 **/
public class P958_CheckCompletenessOfABinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean leafLevel = false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();


            if ((node.left == null && node.right != null) ||
                    (leafLevel && (node.left != null || node.right != null))) {
                return false;
            }

            //if (node.left == null || node.right == null) {
            //    leafLevel = true;
            //}

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            } else {
                leafLevel = true;
            }
        }
        return true;
    }
}
