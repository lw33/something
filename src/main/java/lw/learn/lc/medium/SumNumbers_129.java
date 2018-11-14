package lw.learn.lc.medium;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-14 20:13:42
 **/
public class SumNumbers_129 {

    public int sumNumbers(TreeNode root) {

        List<Integer> nums = new ArrayList<>();

        sumNumbers(root, "", nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
    private void sumNumbers(TreeNode node, String res, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null)
            list.add(Integer.valueOf(res + node.val));
        sumNumbers(node.left,  res + node.val , list);
        sumNumbers(node.right, res + node.val , list);
    }
}
