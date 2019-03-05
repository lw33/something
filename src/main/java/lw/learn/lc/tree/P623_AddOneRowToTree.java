package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2019-03-04 22:40:54
 **/
public class P623_AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode treeNode = new TreeNode(v);
            treeNode.left = root;
            return treeNode;
        }
        if (root == null) {
            return null;
        }

        return addOneRow(root, true, v, d, 1);
    }

    private TreeNode addOneRow(TreeNode node, boolean left, int v, int d, int curDepth) {
        if (d == curDepth) {
            TreeNode treeNode = new TreeNode(v);
            if (left) {
                treeNode.left = node;
            } else {
                treeNode.right = node;
            }
            return treeNode;
        }
        if (node == null) {
            return null;
        }
        node.left = addOneRow(node.left, true, v, d, curDepth + 1);
        node.right = addOneRow(node.right, false, v, d, curDepth + 1);
        return node;
    }
}
