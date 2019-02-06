package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeLinkNode;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2019-01-17 08:28:59
 **/
public class P117_PopulatingNextRightPointersInEachNodeII {

    /**
     * 层序遍历 使用一个变量记录之前的节点
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        // 当前层最后一个节点
        TreeLinkNode levelEnd = root;
        // 下一层最后遍历到的当前最后的一个节点
        TreeLinkNode nextCur = root;
        // 链表 前节点
        TreeLinkNode pre = root;
        // 队列
        LinkedList<TreeLinkNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            TreeLinkNode cur = queue.poll();
            // 如果当前节点不等于前一个节点时
            if (pre != cur) {
                pre.next = cur;
                pre = cur;
            }

            if (cur.left != null) {
                queue.add(cur.left);
                nextCur = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextCur = cur.right;
            }
            if (cur == levelEnd) {
                // 设置当前层最后一个节点指向空
                cur.next = null;
                levelEnd = nextCur;
                // 将 pre 指向下一层第一个节点
                pre = queue.peek();
            }
        }
    }
}
