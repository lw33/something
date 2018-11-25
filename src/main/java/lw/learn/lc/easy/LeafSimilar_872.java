package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-25 23:22:38
 **/
public class LeafSimilar_872 {


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();
        leafs(root1, leafs1);
        leafs(root2, leafs2);
        if (leafs1.size() != leafs2.size()) {
            return false;
        }
        for (int i = 0; i < leafs1.size(); i++) {
            if (!leafs1.get(i).equals(leafs2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void leafs(TreeNode head, List<Integer> leafs) {
        if (head == null) {
            return;
        }
        if (head.left == null && head.right == null) {
            leafs.add(head.val);
            return;
        }
        leafs(head.left, leafs);
        leafs(head.right, leafs);
    }
}
