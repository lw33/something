package lw.learn.lc.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-14 11:57:13
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode() {
    }

    public TreeNode(int x) {
        this(x, null, null, null);
    }

    public TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public static TreeNode aTree() {
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(19);
        root.right.right = new TreeNode(25);
        root.right.left = new TreeNode(15);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        return root;
    }

    /**
     * 通过前序与中序构造二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static List<Integer> inOrder(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {

            if (root != null) {
                stack.push(root);
                root = root.left;

            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * 递归的找左右子树 并将其根返回
     *
     * @param preorder
     * @param inorder
     * @param pStart   前序的左子树开始
     * @param pEnd     前序的左子树结束
     * @param iStart   中序的左子树开始
     * @param iEnd     中序的左子树结束
     * @return 当前树的根
     */
    private static TreeNode buildTree(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {

        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);
        int rootIndex = indexOfArray(inorder, iStart, iEnd, preorder[pStart]);
        int leftLength = rootIndex - iStart;
        // recursive
        root.left = buildTree(preorder, inorder, pStart + 1, pStart + leftLength, iStart, rootIndex - 1);
        root.right = buildTree(preorder, inorder, pStart + leftLength + 1, pEnd, rootIndex + 1, iEnd);
        return root;
    }

    private static int indexOfArray(int[] arr, int start, int end, int target) {

        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
