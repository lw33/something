package lw.learn.offer;


import lw.learn.offer.util.TreeNode;

/**
 * @Author lw
 * @Date 2018-10-02 22:39:37
 * <p>
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 *
 **/
public class P38_GetTreeDepth {
    public int TreeDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return depth(root, 0);
    }

    public int depth(TreeNode node, int depth) {

        if (node == null) {
            return depth;
        }
        return Math.max(depth(node.left, depth + 1), depth(node.right, depth + 1));
    }
}
