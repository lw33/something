package lw.learn.lc.fastest.medium;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-26 23:10:22
 **/
// TODO: 2018/11/26
public class LargestValues_515 {
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            helper(root, res, 0);
            return res;
        }
        private void helper(TreeNode root, List<Integer> res, int d){
            if(root == null){
                return;
            }
            //expand list size
            if(d == res.size()){
                res.add(root.val);
            }
            else{
                //or set value
                res.set(d, Math.max(res.get(d), root.val));
            }
            helper(root.left, res, d+1);
            helper(root.right, res, d+1);
        }
    }
}
