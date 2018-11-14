package lw.learn.lc.easy;

import java.util.HashMap;
import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-11-14 20:19:33
 **/
public class PathSumIII_437 {

    public int pathSum(TreeNode root, int sum) {

        int res = 0;
        if (root == null)
            return res;
        res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);

        return res;
    }

    private int findPath(TreeNode node, int sum) {

        int res = 0;

        if (node == null)
            return res;
        if (node.val == sum)
            res++;
        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);
        return res;
    }

    public int greaterPathSum(TreeNode root, int sum) {
        HashMap<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0, 1);//单个节点的值等于给定的sum。
        return helper(root, 0, sum, preSum);
    }

    private int helper(TreeNode root,int currSum,int target,HashMap<Integer,Integer>preSum){
        if(root==null){
            return 0;
        }
        currSum += root.val;
        int result = preSum.getOrDefault(currSum-target, 0); //找出上个节点，满足（currSum-上个节点sum）= target
        preSum.put(currSum, preSum.getOrDefault(currSum, 0)+1);
        result += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum)-1); //一个节点遍历结束后，做清理工作。
        return result;
    }
}
