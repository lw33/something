package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-22 22:22:08
 **/
public class LevelOrderBottom_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> nodes = new ArrayList<>();
        TreeNode nextLevel = root;
        TreeNode curEnd = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            nodes.add(root.val);

            if (root.left != null) {
                nextLevel  = root.left;
                queue.add(root.left);
            }
            if (root.right != null) {
                nextLevel  = root.right;
                queue.add(root.right);
            }
            if (root == curEnd) {
                res.add(nodes);
                curEnd = nextLevel ;
                nodes = new ArrayList<>();
            }
        }

        Collections.reverse(res);
        return res;
    }
}
