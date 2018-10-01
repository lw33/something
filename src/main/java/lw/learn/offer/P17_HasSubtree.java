package lw.learn.offer;

import lw.learn.offer.util.TreeNode;

import java.util.HashMap;

/**
 * @Author lw
 * @Date 2018-10-01 19:23:37
 * <p>
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 **/
public class P17_HasSubtree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val == root2.val && isSubtree(root1, root2)) {
            return true;
        } else {

            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
    }


    public boolean isSubtree(TreeNode node1, TreeNode node2) {

        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }
        return isSubtree(node1.left, node2.left) && isSubtree(node1.right, node2.right);

    }

}
