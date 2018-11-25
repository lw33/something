package lw.learn.p.z.tree;

import lw.learn.lc.ds.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-24 15:52:21
 **/
public class Morris {

    public List<Integer> morrisPre(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    res.add(cur.val);
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    public List<Integer> morrisIn(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    res.add(cur.val);
                    cur = cur.right;
                    mostRight.right = null;
                }
            } else {
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    public List<Integer> morrisPos(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        TreeNode cur = root;
        TreeNode mostRight;

        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    TreeNode reverse = reverse(cur.left);
                    while (reverse.right != null) {
                        res.add(reverse.val);
                        reverse = reverse.right;
                    }
                    res.add(reverse.val);
                    reverse(reverse);
                }
            }
            cur = cur.right;
        }
        TreeNode reverse = reverse(root);
        while (reverse.right != null) {
            res.add(reverse.val);
            reverse = reverse.right;
        }
        res.add(reverse.val);
        reverse(reverse);
        return res;
    }

    public TreeNode reverse(TreeNode node) {

        TreeNode newHead = null;
        while (node != null) {
            TreeNode revNode = node;
            node = node.right;
            revNode.right = newHead;
            newHead = revNode;
        }
        return newHead;
    }

    @Test
    public void test() {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(7);
        //printTree(head);
        //morrisIn(head);
        //morrisPre(head);
        morrisPos(head);
        //printTree(head);
    }
}
