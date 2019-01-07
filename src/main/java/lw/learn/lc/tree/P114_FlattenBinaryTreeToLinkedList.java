package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2019-01-04 17:16:59
 **/
public class P114_FlattenBinaryTreeToLinkedList {

    /**
     * 将左树接到右树 左树的最右节点 与原右树头结点相接
     * 递归下去
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 如果左节点不为空
        if (root.left != null) {
            // 获取左边最右节点
            TreeNode right = getRight(root.left);
            // 与右头相连
            right.right = root.right;
            // 将根的右指向 左头
            root.right = root.left;
            // 将左树置空
            root.left = null;
            // 递归调用 有子树
            flatten(root.right);
        } else if (root.right != null) {
            // 递归调用 有子树
            flatten(root.right);
        }
    }

    /**
     * 获取当前节点的最右节点
     * @param node
     * @return
     */
    private TreeNode getRight(TreeNode node) {

        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
