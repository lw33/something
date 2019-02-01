package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeLinkNode;

/**
 * @Author lw
 * @Date 2019-01-17 08:28:59
 **/
public class P117_PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        TreeLinkNode nextHead = null;
        TreeLinkNode nextPre = nextHead;
        TreeLinkNode cur = root;
        while (nextHead == null || cur != null) {
            if (cur != null) {
                if (cur.left != null) {
                    if (nextHead == null) {
                        nextHead = cur.left;
                    }
                    nextPre.next = cur.left;
                    nextPre = nextPre.next;
                }
                if (cur.right != null) {
                    if (nextHead == null) {
                        nextHead = cur.left;
                    }
                    nextPre.next = cur.right;
                    nextPre = nextPre.next;
                }
            } else {
                cur = nextHead;
                nextPre = nextHead;
                nextHead = null;
            }
        }
    }
}
