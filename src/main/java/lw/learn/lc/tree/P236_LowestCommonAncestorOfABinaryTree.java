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
}
