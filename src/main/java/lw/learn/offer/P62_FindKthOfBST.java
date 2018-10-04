package lw.learn.offer;

import lw.learn.offer.util.TreeNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-03 22:56:12
 **/
public class P62_FindKthOfBST {

    @Test
    public void test() {
        //8,6,10,5,7,9,11
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        System.out.println(this.KthNode(root, 3).val);
    }


    TreeNode KthNode(TreeNode pRoot, int k) {

        if (pRoot == null || k == 0) {
            return null;
        }

        int[] ks = new int[1];
        ks[0] = k;
        return inOrder(pRoot, ks);
    }

    public TreeNode inOrder(TreeNode node, int[] k) {


        TreeNode target = null;

        if (node.left != null) {
            target = inOrder(node.left, k);
        }
        if (target == null) {
            if (k[0] == 1) {
                target = node;
            }
            k[0]--;
        }
        if (target == null && node.right != null) {
            target = inOrder(node.right, k);
        }
        return target;
    }

}
