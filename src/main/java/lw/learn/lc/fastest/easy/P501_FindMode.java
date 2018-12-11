package lw.learn.lc.fastest.easy;

import lw.learn.lc.ds.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-25 23:34:53
 **/
// TODO: 2018/11/25 待弄懂
public class P501_FindMode {
    class Solution {
        Integer preValue;
        int count = 1, max = 0;

        public int[] findMode(TreeNode root) {
            List<Integer> list = new LinkedList<>();
            travellingTree(root, list);
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }

            return res;
        }

        private void travellingTree(TreeNode root, List<Integer> list) {
            if (root == null)
                return;
            travellingTree(root.left, list);
            if (preValue != null) {
                if (preValue == root.val)
                    count++;
                else
                    count = 1;
            }
            if (count == max) {
                list.add(root.val);
            } else if (count > max) {
                list.clear();
                max = count;
                list.add(root.val);
            }
            preValue = root.val;

            travellingTree(root.right, list);
        }
    }
}
