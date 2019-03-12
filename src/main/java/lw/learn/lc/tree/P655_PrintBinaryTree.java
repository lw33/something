package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-03-12 11:50:15
 **/
public class P655_PrintBinaryTree {

    /**
     * 求出树的高度
     * 然后递归的将数据填入
     *
     * @param root
     * @return
     */
    public List<List<String>> printTree(TreeNode root) {

        if (root == null) {
            return new LinkedList<>();
        }

        int h = height(root);
        int row = (int) (Math.pow(2, h) - 1);
        List<List<String>> res = new LinkedList<>();
        List<String> list = new ArrayList<>(row);
        for (int i = 0; i < row; i++) {
            list.add("");
        }
        for (int i = 0; i < h; i++) {
            res.add(new ArrayList<>(list));
        }

        dfs(root, res, 0, 0, row);
        return res;
    }

    /**
     * level 当前层从 0 开始
     * l 最左点
     * r 最右点
     *
     * @param node
     * @param res
     * @param level
     * @param l
     * @param r
     */
    private void dfs(TreeNode node, List<List<String>> res, int level, int l, int r) {
        if (node == null) {
            return;
        }

        int mid = l + ((r - l) >> 1);
        res.get(level).set(mid, String.valueOf(node.val));
        dfs(node.left, res, level + 1, l, mid);
        dfs(node.right, res, level + 1, mid + 1, r);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(this.printTree(root));
    }
}
