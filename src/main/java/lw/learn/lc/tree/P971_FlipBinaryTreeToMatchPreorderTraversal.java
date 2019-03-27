package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-03-20 14:40:15
 **/
public class P971_FlipBinaryTreeToMatchPreorderTraversal {

    int i = 0;
    List<Integer> res;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

        res = new ArrayList<>();
        dfs(root, voyage);

        return res;
    }

    private void dfs(TreeNode node, int[] voyage) {
        if (node == null) {
            return;
        }
        if (voyage[i] != node.val) {
            res.add(-1);
            return;
        }
    }
}
