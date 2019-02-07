package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2019-02-07 09:55:36
 **/
public class P99_RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {

    }

    public void recoverTreeStack(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        boolean hasReverseNode = false;
        TreeNode revNode1 = null;
        TreeNode revNode2 = null;
        TreeNode revNode3 = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (!nodes.isEmpty()) {
                    TreeNode treeNode = nodes.peekLast();
                    if (root.val < treeNode.val) {
                        if (hasReverseNode) {
                            revNode3 = root;
                            swap(revNode1, revNode3);
                            return;
                        }
                        revNode1 = treeNode;
                        revNode2 = root;
                        hasReverseNode = true;
                    }
                }
                nodes.add(root);
                root = root.right;
            }
        }
        swap(revNode1, revNode2);
    }

    private void swap(TreeNode node1, TreeNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }


    @Test
    public void test() {
        int[] preOrder = {3, 1, 4, 2};
        int[] inOrder = {1, 3, 2, 4};
        TreeNode treeNode = TreeNode.buildTree(preOrder, inOrder);
        this.recoverTreeStack(treeNode);
        System.out.println(TreeNode.inOrder(treeNode));
    }
}
