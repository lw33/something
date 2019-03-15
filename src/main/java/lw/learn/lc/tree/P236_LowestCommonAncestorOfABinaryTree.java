package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2019-02-06 22:30:06
 **/
public class P236_LowestCommonAncestorOfABinaryTree {

    /**
     * O(n)
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pfs = new LinkedList<>();
        LinkedList<TreeNode> qfs = new LinkedList<>();
        findFs(root, p, pfs);  // O(n)
        findFs(root, q, qfs);   // O(n)
        if (pfs.contains(q)) { // O(n)
            return q;
        }
        if (qfs.contains(p)) { // O(n)
            return p;
        }

        // O(n)

        while (pfs.size() > qfs.size()) {
            pfs.removeLast();
        }
        while (qfs.size() > pfs.size()) {
            qfs.removeLast();
        }
        while (!pfs.isEmpty() && !qfs.isEmpty()) {
            TreeNode pf = pfs.removeLast();
            TreeNode qf = qfs.removeLast();
            if (pf == qf) {
                return pf;
            }
        }
        return null;
    }

    /**
     * 找父节点
     *
     * @param node
     * @param treeNode
     * @param fs
     * @return
     */
    private boolean findFs(TreeNode node, TreeNode treeNode, LinkedList<TreeNode> fs) {
        if (node == treeNode) {
            return true;
        }
        if (node == null) {
            return false;
        }
        boolean find = findFs(node.left, treeNode, fs) || findFs(node.right, treeNode, fs);
        if (find) {
            fs.addFirst(node);
        }
        return find;
    }

    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        /**
         注意p,q必然存在树内, 且所有节点的值唯一!!!
         递归思想, 对以root为根的(子)树进行查找p和q, 如果root == null || p || q 直接返回root
         表示对于当前树的查找已经完毕, 否则对左右子树进行查找, 根据左右子树的返回值判断:
         1. 左右子树的返回值都不为null, 由于值唯一左右子树的返回值就是p和q, 此时root为LCA
         2. 如果左右子树返回值只有一个不为null, 说明只有p和q存在与左或右子树中, 最先找到的那个节点为LCA
         3. 左右子树返回值均为null, p和q均不在树中, 返回null
         **/
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestorII(root.left, p, q);
        TreeNode right = lowestCommonAncestorII(root.right, p, q);
        if (left == null && right == null) return null;
        else if (left != null && right != null) return root;
        else return left == null ? right : left;
    }
}
