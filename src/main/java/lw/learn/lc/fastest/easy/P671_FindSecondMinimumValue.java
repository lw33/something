package lw.learn.lc.fastest.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-12-04 11:21:23
 **/
// TODO: 2018/12/4 666 
public class P671_FindSecondMinimumValue {

    class Solution {
        public int findSecondMinimumValue(TreeNode root) {
            int min = root.val;
            return findFirstDifferentValue(root,min);
        }

        public int findFirstDifferentValue(TreeNode root,int n){
            if(root == null){
                return -1;
            }
            if(root.val == n){
                int left = findFirstDifferentValue(root.left,n);
                int right = findFirstDifferentValue(root.right,n);
                if(left == -1 || right == -1){
                    return left>right ? left : right;
                }
                return left<right ? left : right;
            }
            return root.val;
        }
    }
}
