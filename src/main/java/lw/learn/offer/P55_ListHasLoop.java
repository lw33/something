package lw.learn.offer;

import lw.learn.offer.util.ListNode;

/**
 * @Author lw
 * @Date 2018-10-03 19:46:10
 * <p>
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 **/
public class P55_ListHasLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead) {


        if (pHead == null) {
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast.next == null) {
            return null;
        }
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
