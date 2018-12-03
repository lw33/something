package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-03 22:22:34
 **/
public class ConvertBST_538 {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        rightOrder(root);
        return root;
    }

    public void rightOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        rightOrder(node.right);
        int oldValue = node.val;
        node.val = node.val + sum;
        sum += oldValue;
        rightOrder(node.left);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(19);
        root.right.right = new TreeNode(25);
        root.right.left = new TreeNode(15);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        this.convertBST(root);
    }
}
