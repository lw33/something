package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-12-03 21:48:02
 **/
public class P572_IsSubtree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val && subTree(s, t)) {
            return true;
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    public boolean subTree(TreeNode s, TreeNode t) {

        if (t == null && s == null) {
            return true;
        }
        if (t == null || s == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }

        return subTree(s.left, t.left) && subTree(s.right, t.right);
    }
}
