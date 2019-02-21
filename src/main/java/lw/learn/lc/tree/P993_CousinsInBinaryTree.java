package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2019-02-21 21:57:03
 **/
public class P993_CousinsInBinaryTree {

    TreeNode[] roots = new TreeNode[2];
    int index = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        int d1 = dfs(root, x);
        int d2 = dfs(root, y);
        if (roots[0] == roots[1]) {
            return false;
        }
        return d1 == d2;
    }

    public int dfs(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        if (node.val == val) {
            return 1;
        }
        int deep = dfs(node.left, val);
        if (deep == 1) {
            roots[index++] = node;
        }
        if (deep > 0) {
            return deep + 1;
        }
        deep = dfs(node.right, val);
        if (deep == 1) {
            roots[index++] = node;
        }
        return deep > 0 ? deep + 1 : 0;
    }
}
