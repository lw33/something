package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-06 21:45:45
 **/
public class P61_RotateRight {
    public ListNode rotateRightAAA(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode node1 = head;
        ListNode end = null;
        int length = 0;
        while (node1 != null) {
            length++;
            end = node1;
            node1 = node1.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        node1 = head;
        length = length - k - 1;
        for (int i = 0; i < length; i++) {
            node1 = node1.next;
        }
        ListNode newHead = node1.next;
        node1.next = null;
        end.next = head;
        return newHead;
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0) {
            return head;
        }

        ListNode node1 = head;
        ListNode node2 = head;
        for (int i = 0; i < k; i++) {
            node1 = node1.next;
            if (node1 == null) {
                node1 = head;
            }
        }
        if (node1 == head) {
            return head;
        }
        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        ListNode newHead = node2.next;
        node2.next = null;
        node1 = newHead;
        while (node1.next != null) {
            node1 = node1.next;
        }
        node1.next = head;
        return newHead;
    }
    
    @Test
    public void test() {
        int[] arr = {1, 2, 3};
        ListNode root = ListNode.buildList(arr);
        ListNode node = this.rotateRightAAA(root, 200000);
        ListNode.printList(node);
    }
}
