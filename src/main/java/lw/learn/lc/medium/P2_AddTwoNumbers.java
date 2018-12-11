package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-24 21:11:51
 **/
public class P2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int i = l1.val + l2.val + carry;
            if (i >= 10) {
                carry = 1;
                i = i % 10;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(i);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int i = l1.val + carry;
            if (i >= 10) {
                carry = 1;
                i = i % 10;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(i);
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int i = l2.val + carry;
            if (i >= 10) {
                carry = 1;
                i = i % 10;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(i);
            cur = cur.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return newHead.next;
    }



    @Test
    public void test() {
        int[] arr1 = {1, 8};
        int[] arr2 = {0};
        ListNode l1 = ListNode.buildList(arr1);
        ListNode l2 = ListNode.buildList(arr2);

        ListNode listNode = this.addTwoNumbers(l1, l2);
        listNode.printList(listNode);
    }
}
