package lw.learn.offer;

import lw.learn.offer.util.TreeNode;

/**
 * @Author lw
 * @Date 2018-10-03 20:28:34
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 **/
public class P58_IsSymmetricalTree {

    boolean isSymmetrical(TreeNode pRoot) {

        return isSymmetrical(pRoot,pRoot);
    }

    boolean isSymmetrical(TreeNode tree1, TreeNode tree2) {

        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {

            return false;
        }
        if (tree2.val != tree1.val) {
            return false;
        }

        return isSymmetrical(tree1.left, tree2.right) && isSymmetrical(tree1.right, tree2.left);

    }
}
