package lw.learn.offer;

import lw.learn.offer.util.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author lw
 * @Date 2018-10-02 13:29:59
 * 题目描述
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 **/
public class P24_FindPath {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> nodes = new ArrayList<>();
        findPath(root, 0, target, nodes, res);
        return res;
    }

    public void findPath(TreeNode node, int sum, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        sum += node.val;

        if (sum == target && node.left == null && node.right == null) {
            ArrayList<Integer> tmp = new ArrayList<>();
            //tmp.addAll(path);
            res.add(tmp);
            sum -= node.val;
            path.remove(path.size() - 1);
            return;
        }else if (sum > target) {
            sum -= node.val;
            path.remove(path.size() - 1);
            return;
        }
        findPath(node.left, sum, target, path, res);
        findPath(node.right, sum, target, path, res);
        path.remove(path.size() - 1);
        sum -= node.val;
    }


    @Test
    public void test() {
        int[] arr = {10, 5, 12, 4, 7};
        int target = 22;
        //this.FindPath()
    }

}
