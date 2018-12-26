package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-25 23:42:42
 **/
public class P92_ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (n < m || head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (head != null && m != 1) {
            --m;
            --n;
            pre = head;
            head = head.next;
        }
        if (m != 1) {
            return dummyHead.next;
        }
        ListNode start = head;
        while (head != null && n != 1) {
            --n;
            head = head.next;
        }
        if (n != 1) {
            return dummyHead.next;
        }
        ListNode end = head.next;
        head.next = null;
        pre.next = reverse(start);
        start.next = end;
        return dummyHead.next;
    }
    public ListNode reverseBetween1(ListNode head, int m, int n) {

        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (m != 1) {
            --m;
            --n;
            pre = head;
            head = head.next;
        }
        ListNode newHead = null;
        while (n != 0) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = newHead;
            newHead = tmp;
            --n;
        }
        pre.next.next = head;
        pre.next = newHead;
        return dummyHead.next;
    }
    public ListNode reverse(ListNode node) {

        ListNode newHead = null;
        while (node != null) {
            ListNode tmp = node;
            node = node.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.buildList(arr);
        ListNode listNode1 = this.reverseBetween1(listNode, 2, 4);
        ListNode.printList(listNode1);

    }
}
