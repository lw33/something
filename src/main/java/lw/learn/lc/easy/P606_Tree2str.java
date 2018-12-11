package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-03 22:50:11
 **/
public class P606_Tree2str {

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preOrder(t, sb);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("()");
            return;
        }
        sb.append("(");
        sb.append(node.val);
        if (node.right != null || node.left != null) {
            preOrder(node.left, sb);
        }
        if (node.right != null) {
            preOrder(node.right, sb);
        }
        sb.append(")");
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
        System.out.println(this.tree2str(root));
    }
}
