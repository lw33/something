package lw.learn.lc.fastest.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-12-05 12:30:30
 **/
public class P897_IncreasingBST {
    class Solution {
        TreeNode pre = null;
        public TreeNode increasingBST(TreeNode root) {
            if(root == null) {
                return null;
            }
            TreeNode[] pre = new TreeNode[2];
            dfs(root, pre);
            return pre[0];
        }

        void dfs(TreeNode root, TreeNode[] pre)
        {
            if(root == null) {
                return ;
            }
            dfs(root.left, pre);
            if(pre[0] == null)
            {
                pre[0] = root;
                pre[1] = root;
            }
            else{
                pre[1].right = root;
                root.left = null;
                pre[1] = root;
            }
            dfs(root.right, pre);
        }
    }
}
