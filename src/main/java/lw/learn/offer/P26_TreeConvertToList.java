package lw.learn.offer;

import lw.learn.offer.util.TreeNode;

/**
 * @Author lw
 * @Date 2018-10-02 18:05:23
 **/
public class P26_TreeConvertToList {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null)) {
            return pRootOfTree;
        }

        TreeNode[] pre = new TreeNode[1];
        converTree(pRootOfTree, pre);
        while (pRootOfTree.left != null) {
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }

    public void converTree(TreeNode node, TreeNode[] pre) {

        if (node == null) {
            return;
        }

        converTree(node.left, pre);

        node.left = pre[0];
        if (pre[0] != null) {
            pre[0].right = node;
        }
        pre[0] = node;
        converTree(node.right, pre);
    }
}
