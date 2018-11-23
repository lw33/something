package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-11-23 12:50:47
 **/
public class IsSameTree_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == q)
            return true;

        if (p == null || q == null)
            return false;
       /* if (p.val != q.val)
            return false;*/
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
