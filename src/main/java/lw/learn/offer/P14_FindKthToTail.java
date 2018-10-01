package lw.learn.offer;

import lw.learn.offer.util.ListNode;

/**
 * @Author lw
 * @Date 2018-10-01 19:05:14
 * <p>
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 **/

public class P14_FindKthToTail {

    public ListNode FindKthToTail(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (k > 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            k--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
