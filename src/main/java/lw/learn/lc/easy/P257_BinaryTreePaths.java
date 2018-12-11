package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-14 19:29:20
 **/
public class P257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        binaryTreePaths(root, "", res);
        return res;
    }

    private void binaryTreePaths(TreeNode node, String res, List<String> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null)
            list.add(res + node.val);
        binaryTreePaths(node.left,  res + node.val + "->", list);
        binaryTreePaths(node.right, res + node.val + "->", list);
    }
}
