package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2019-01-17 23:16:04
 **/
// FIXME 2019/1/17  morris
public class P230_KthSmallestElementInABST {

  /*  int res = 0;
    public int amazing(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            res = amazing(root.left, k);
        }
        --k;
        if (k == 0) {
            return res;
        }
        if (root.right != null) {
            res = amazing(root.right, k);
        }
        return res;
    }*/

    int index = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        index = k;
        inOrder(root);
        return res;
    }
    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        index--;
        if (index == 0) {
            res = node.val;
            return;
        }
        if(index < 0) return;
        inOrder(node.right);
    }
}
