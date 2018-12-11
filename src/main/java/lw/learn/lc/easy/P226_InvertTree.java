package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-11-14 19:00:34
 **/
public class P226_InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
