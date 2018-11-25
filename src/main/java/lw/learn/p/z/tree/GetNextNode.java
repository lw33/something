package lw.learn.p.z.tree;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-11-21 14:08:46
 **/
public class GetNextNode {

    public TreeNode getNextNode(TreeNode node) {

        if (node == null)
            return null;

        if (node.right != null) {
            return getLeft(node.right);
        } else {
            TreeNode parent = node.parent;
            while (parent != null &&  parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public TreeNode getLeft(TreeNode node) {
        //if (node == null || node.left == null)
        //    return node;
        //return getLeft(node.left);
        if (node == null)
            return null;
        while (node.left != null)
            node = node.left;
        return node;
    }
}
