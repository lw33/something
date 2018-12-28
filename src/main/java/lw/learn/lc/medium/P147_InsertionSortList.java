package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;

/**
 * @Author lw
 * @Date 2018-12-28 01:21:19
 **/
public class P147_InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = head;
        ListNode cur = head.next;

        if (cur == null) {
            return head;
        }
        newHead.next = null;

        while (cur != null) {
            ListNode tmp = newHead;
            while (tmp != null) {
                
            }
            cur = cur.next;
        }

        return null;
    }
}
