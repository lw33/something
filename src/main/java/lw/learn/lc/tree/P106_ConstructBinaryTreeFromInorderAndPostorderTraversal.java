package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;
import lw.learn.utils.ArrayHelper;

/**
 * @Author lw
 * @Date 2019-02-07 09:38:11
 **/
public class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int iStart, int iEnd, int pStart, int pEnd) {

        if (iEnd < iStart || pEnd < pStart) {
            return null;
        }
        int rootValue = postorder[pEnd];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = ArrayHelper.indexOfArray(inorder, iStart, iEnd, rootValue);
        int leftLength = rootIndex - iStart;
        root.left = buildTree(inorder, postorder, iStart, rootIndex - 1, pStart, pStart + leftLength - 1);
        root.right = buildTree(inorder, postorder, rootIndex + 1, iEnd, pStart + leftLength, pEnd - 1);
        return root;
    }


}
