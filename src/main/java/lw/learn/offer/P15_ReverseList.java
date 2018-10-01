package lw.learn.offer;

import lw.learn.offer.util.ListNode;

/**
 * @Author lw
 * @Date 2018-10-01 19:09:21
 *
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 **/
public class P15_ReverseList {

    public ListNode ReverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;

        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }

}
