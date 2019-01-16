package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeLinkNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-16 21:50:18
 **/
public class P116_PopulatingNextRightPointersInEachNode {
    /*void connect(TreeLinkNode *root) {
        if (root == NULL)
            return;
        TreeLinkNode* pre = root;
        TreeLinkNode* cur = NULL;
        while (pre->left)
        {
            cur = pre;
            while (cur)
            {
                cur->left->next = cur->right;
                if (cur->next)
                    cur->right->next = cur->next->left;
                cur = cur->next;
            }
            pre = pre->left;
        }
    }*/

    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null) {
            return;
        }
        root.next = null;
        TreeLinkNode preHead = root;
        TreeLinkNode cur = root;
        while (preHead.left != null) {
            if (cur.next != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next.left;
            } else {
                cur.left.next = cur.right;
                cur.right.next = null;
                preHead = preHead.left;
                cur = preHead;
                continue;
            }
            cur = cur.next;
        }
    }

    @Test
    public void test() {
        //{1,2,3}
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        this.connect(root);
        System.out.println();
    }
}
