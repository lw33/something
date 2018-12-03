package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

import java.util.HashSet;

/**
 * @Author lw
 * @Date 2018-12-03 23:05:30
 **/
// TODO: 2018/12/3 morris 重构
public class FindTarget_653 {

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        preOrder(root, set);

        for (Integer integer : set) {
            int t = k - integer;
            if (t != integer) {
                if (set.contains(t)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void preOrder(TreeNode node, HashSet<Integer> set) {
        if (node == null) {
            return;
        }
        set.add(node.val);
        preOrder(node.left, set);
        preOrder(node.right, set);
    }
}
