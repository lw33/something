package lw.learn.p.z.linkedList;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-20 17:44:45
 **/
public class ListPartition {

    public ListNode partition(ListNode head, int pivot) {
        if (head == null || head.next == null)
            return head;

        ListNode lessStart = null;
        ListNode lessEnd = null;
        ListNode eqStart = null;
        ListNode eqEnd = null;
        ListNode moreStart = null;
        ListNode moreEnd = null;
        ListNode cur = head;
        ListNode next = cur;
        while (cur != null) {
            next = cur.next;
            if (cur.val < pivot) {

                if (lessStart == null)
                    lessStart = cur;
                else
                    lessEnd.next = cur;

                lessEnd = cur;
                lessEnd.next = null;
            } else if (cur.val > pivot) {

                if (moreStart == null)
                    moreStart = cur;
                 else
                    moreEnd.next = cur;
                moreEnd = cur;
                moreEnd.next = null;
            } else {

                if (eqStart == null)
                    eqStart = cur;
                else
                    eqEnd.next = cur;

                eqEnd = cur;
                eqEnd.next = null;
            }
            cur = next;
        }

        if (lessEnd != null) {
            lessEnd.next = eqStart;
            eqEnd = eqEnd == null ? lessEnd : eqEnd;
        }

        if (eqEnd != null)
            eqEnd.next = moreStart;

        //return lessEnd == null ? eqEnd == null ? moreStart : eqStart : lessStart;
        return lessEnd != null ? lessStart : eqStart != null ? eqStart : moreStart;
    }

    @Test
    public void test() {
        int[] arr = {1, 32, 2, 2, 3, 4, 44, 5, 56, 5, 4};
        ListNode listNode = ListNode.buildList(arr);
        ListNode partition = this.partition(listNode, 4);
        ListNode.printList(partition);
    }
}
