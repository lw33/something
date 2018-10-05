package lw.learn.offer;

import lw.learn.offer.util.TreeLinkNode;

/**
 * @Author lw
 * @Date 2018-10-03 20:26:37
 * <p>
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 **/
public class P57_GetInOrderTreeNextNode {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        if (pNode.right == null) {
            TreeLinkNode parent = pNode.next;
            while (parent != null && parent.left != pNode) {
                pNode = parent;
                parent = parent.next;
            }
            return parent;
        } else {
            return getLeft(pNode.right);
        }

    }

    public TreeLinkNode getLeft(TreeLinkNode node) {
        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}
