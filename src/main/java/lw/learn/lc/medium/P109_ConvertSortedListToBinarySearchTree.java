package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;
import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-12-26 00:51:33
 **/
public class P109_ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        int[] vals = new int[length];
        cur = head;
        for (int i = 0; i < vals.length; i++) {
            vals[i] = cur.val;
            cur = cur.next;
        }
        return findRoot(vals, 0, length - 1);
    }

    private TreeNode findRoot(int[] vals, int start, int end) {
        if (end < start) {
            return null;
        }
        if (start == end) {
            return new TreeNode(vals[start]);
        }
        int mid = start + ((end - start) >> 1);
        TreeNode root = new TreeNode(vals[mid]);
        root.left = findRoot(vals, start, mid - 1);
        root.right = findRoot(vals, mid + 1, end);
        return root;
    }
}
