package lw.learn.offer;

import lw.learn.offer.util.ListNode;

/**
 * @Author lw
 * @Date 2018-10-01 19:13:06
 **/
public class P16_MergeList {

    public ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode newHead = new ListNode(666);

        ListNode cur = newHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        while (list1 != null) {
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }

        while (list2 != null) {
            cur.next = list2;
            cur = cur.next;
            list2 = list2.next;
        }
        return newHead.next;
    }
}
