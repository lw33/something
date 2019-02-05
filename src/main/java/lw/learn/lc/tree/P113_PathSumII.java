package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-05 19:13:07
 **/
public class P113_PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void pathSum(TreeNode node, int sum, ArrayList<Integer> list, List<List<Integer>> res) {

        if (node == null) {
            return;
        }

        sum = sum - node.val;
        list.add(node.val);
        if (node.left == null && node.right == null && sum == 0) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        pathSum(node.left, sum, list, res);
        pathSum(node.right, sum, list, res);
        list.remove(list.size() - 1);
    }
}
