package lw.learn.offer;

import lw.learn.offer.util.ListNode;

/**
 * @Author lw
 * @Date 2018-10-03 19:59:44
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 **/
public class P56_DeleteDuplicationInLinkedList {
    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode newHead = new ListNode(-pHead.val);
        ListNode p = newHead;
        ListNode q = pHead;

        int pre = newHead.val;
        while (q.next != null) {
            if (pre != q.val && q.next.val != q.val) {
                p.next = q;
                p = q;
            }
            pre = q.val;
            q = q.next;
        }
        p.next = null;
        if (q.val != pre) {
            p.next = q;
        }
        return newHead.next;
    }


}
