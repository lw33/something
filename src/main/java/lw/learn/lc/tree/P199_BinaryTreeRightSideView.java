package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-27 18:40:33
 **/
public class P199_BinaryTreeRightSideView {

    /**
     * 二叉树的右视图 只要找到二叉树每一层的最后一个节点放入 list 中即可
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        TreeNode nextLevel = root;
        TreeNode curLevelEnd = root;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                nextLevel = cur.left;
                queue.add(cur.left);
            }
            if (cur.right != null) {
                nextLevel = cur.right;
                queue.add(cur.right);
            }
            if (cur == curLevelEnd) {
                res.add(cur.val);
                curLevelEnd = nextLevel;
            }
        }

        return res;
    }
}
