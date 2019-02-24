package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-11-21 16:14:17
 * @tag medium
 **/
public class P222_CountNodes {

    // 2^n - 1
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        return countNodes(root, 1, deep(root, 1));
    }

    private int countNodes(TreeNode node, int level, int deep) {
        if (level == deep) {
            return 1;
        }
        if (deep(node.right, level + 1) == deep) {
            return (1 << (deep - level - 1)) + countNodes(node.right, level + 1, deep);
        } else {
            return (1 << (deep - level - 2) + countNodes(node.left, level + 1, deep));
        }
    }

    private int deep(TreeNode node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return --level;
    }
}
