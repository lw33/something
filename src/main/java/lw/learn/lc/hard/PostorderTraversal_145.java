package lw.learn.lc.hard;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-21 11:54:11
 * @tag hard
 **/
public class PostorderTraversal_145 {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    public void inOrder(TreeNode node, List<Integer> res) {
        if(node == null)
            return;
        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right, res);
    }
}
