package lw.learn.offer;

import lw.learn.offer.util.TreeNode;

/**
 * @Author lw
 * @Date 2018-10-02 22:47:22
 *
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
 *
 **/
public class P39_IsBalancedTree {

    public boolean IsBalanced_Solution(TreeNode root) {


        return isBanlance(root).isBalance;
    }

    public RetureData isBanlance(TreeNode node) {

        if (node == null) {
            return new RetureData(0, true);
        }

        RetureData left = isBanlance(node.left);

        if (!left.isBalance) {
            return new RetureData(0, false);
        }

        RetureData right = isBanlance(node.right);

        if (!right.isBalance) {
            return new RetureData(0, false);
        }
        if (Math.abs(right.h - left.h) > 1) {
            return new RetureData(0, false);
        }

        return new RetureData(Math.max(left.h, right.h) + 1, true);
    }

    class RetureData {
        int h;
        boolean isBalance;

        public RetureData(int h, boolean isBalance) {
            this.h = h;
            this.isBalance = isBalance;
        }
    }
























}
