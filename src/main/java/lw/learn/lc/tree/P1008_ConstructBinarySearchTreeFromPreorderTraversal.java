package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2019-03-11 16:28:22
 **/
public class P1008_ConstructBinarySearchTreeFromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int l, int r) {
        if (l == r) {
            return new TreeNode(preorder[l]);
        } else if (l > r) {
            return null;
        }
        TreeNode node = new TreeNode(l);
        for (int i = l + 1; i <= r; i++) {
            if (preorder[i] > preorder[l]) {
                node.left = dfs(preorder, l + 1, i - 1);
                node.right = dfs(preorder, i, r);
                break;
            }
        }
        /**
         * 当 右边的数全是小于当前数时
         */
        if (node.right == null) {
            node.left = dfs(preorder, l + 1, r);
        }
        return node;
    }

}
