package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2019-03-04 22:06:24
 **/
public class P951_FlipEquivalentBinaryTrees {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                (flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right));

    }
}
