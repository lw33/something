package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-08 21:41:03
 **/
public class P508_MostFrequentSubtreeSum {

    int maxFreq = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {

        HashMap<Integer, Integer> map = new HashMap<>();
        subTreeSum(root, map);
        List<Integer> resList = new LinkedList<>();
        map.forEach((k, v) -> {
            if (maxFreq == v) {
                resList.add(k);
            }
        });
        int[] res = new int[resList.size()];
        int i = 0;
        for (Integer value : resList) {
            res[i++] = value;
        }
        return res;
    }

    private int subTreeSum(TreeNode node, HashMap<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        int leftSum = subTreeSum(node.left, map);
        int rightSum = subTreeSum(node.right, map);
        int sum = node.val + leftSum + rightSum;
        int newFreq = map.getOrDefault(sum, 0) + 1;
        map.put(sum, newFreq);
        maxFreq = maxFreq < newFreq ? newFreq : maxFreq;
        return sum;
    }

}
