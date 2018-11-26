package lw.learn.lc.medium;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author lw
 * @Date 2018-11-26 11:49:51
 **/
public class LargestValues_515 {

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode levelEnd = root;
        TreeNode nextLevel = null;
        queue.add(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextLevel = cur.left;
            }

            if (cur.right != null) {
                queue.add(cur.right);
                nextLevel = cur.right;
            }
            max = Math.max(max, cur.val);
            if (cur == levelEnd) {
                levelEnd = nextLevel;
                res.add(max);
                max = Integer.MIN_VALUE;
            }

        }
        return res;
    }
}
