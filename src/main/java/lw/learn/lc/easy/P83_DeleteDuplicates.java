package lw.learn.lc.easy;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-18 14:36:50
 **/
public class P83_DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode cursor1 = head;
        ListNode cursor2 = head;

        while (cursor1 != null) {
            while (cursor2.next != null) {
                if (cursor1.val == cursor2.next.val) {
                    ListNode next = cursor2.next;
                    cursor2.next = cursor2.next.next;
                    next.next = null;
                } else {
                    cursor2 = cursor2.next;
                }
            }
            cursor1 = cursor1.next;
        }

        return head;
    }

    public ListNode deleteDuplicatesF(ListNode head) {

        ListNode cursor1 = head;
        ListNode cursor2 = head;

        while (cursor2.next != null) {

            if (cursor2.next.val == cursor1.val) {
                ListNode next = cursor2.next;
                cursor2.next = cursor2.next.next;
                next.next = null;
            } else {
                cursor2 = cursor2.next;
                cursor1 = cursor2;
            }
        }

        return head;
    }

    @Test
    public void test() {
        int[] arr = {1, 1, 2, 2, 3, 3};
        ListNode.printList(this.deleteDuplicatesF(ListNode.buildList(arr)));
    }
}
