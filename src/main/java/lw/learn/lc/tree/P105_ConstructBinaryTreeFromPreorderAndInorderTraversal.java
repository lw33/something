package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2019-02-07 08:51:45
 **/
public class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * 通过前序与中序构造二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
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
    private TreeNode buildTree(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {

        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);
        int rootIndex = indexOfArray(inorder, iStart, iEnd, preorder[pStart]);
        int leftLength = rootIndex - iStart;
        root.left = buildTree(preorder, inorder, pStart + 1, pStart + leftLength, iStart, rootIndex - 1);
        root.right = buildTree(preorder, inorder, pStart + leftLength + 1, pEnd, rootIndex + 1, iEnd);
        return root;
    }

    private int indexOfArray(int[] arr, int start, int end, int target) {

        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
