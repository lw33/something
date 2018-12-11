package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-04 11:02:35
 **/
public class P637_AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> avgs = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode endOfLevel = root;
        TreeNode nextLevelNode = null;
        queue.add(root);
        double sum = 0.0;
        int size = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            sum += cur.val;
            size++;
            if (cur.left != null) {
                queue.add(cur.left);
                nextLevelNode = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextLevelNode = cur.right;
            }
            if (endOfLevel == cur) {
                endOfLevel = nextLevelNode;
                avgs.add(sum / size);
                sum = 0.0;
                size = 0;
            }
        }
        return avgs;
    }


}
