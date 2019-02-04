package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2019-02-03 17:17:47
 **/
public class P814_BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null) {
            if (root.val == 0) {
                return null;
            }
        }

        return root;
    }

}
