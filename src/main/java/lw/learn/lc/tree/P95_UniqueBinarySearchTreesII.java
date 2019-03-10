package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-07 10:20:36
 **/
public class P95_UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int l, int r) {
        List<TreeNode> res = new ArrayList<>();
        if (l > r) {
            res.add(null);
            return res;
        }
        if (l == r) {
            res.add(new TreeNode(l));
            return res;
        }

        for (int i = l; i <= r; i++) {
            List<TreeNode> left = dfs(l, i - 1);
            List<TreeNode> right = dfs(i + 1, r);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode tmpRoot = new TreeNode(i);
                    tmpRoot.left = leftNode;
                    tmpRoot.right = rightNode;
                    res.add(tmpRoot);
                }
            }
        }
        return res;
    }
}
