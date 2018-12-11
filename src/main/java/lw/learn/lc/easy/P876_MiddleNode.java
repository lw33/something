package lw.learn.lc.easy;

import lw.learn.lc.ds.ListNode;

/**
 * @Author lw
 * @Date 2018-11-20 17:15:55
 **/
public class P876_MiddleNode {
    public ListNode middleNode(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast.next == null ? slow : slow.next;
    }
}
