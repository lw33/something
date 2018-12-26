package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-26 01:05:00
 **/
public class P143_ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode fastCursor = head;
        ListNode slowCursor = head;
        while (fastCursor.next != null) {
            if (fastCursor.next.next == null) {
                break;
            }
            slowCursor = slowCursor.next;
            fastCursor = fastCursor.next.next;
        }
        ListNode start = slowCursor.next;
        slowCursor.next = null;
        ListNode endHead = null;
        while (start != null) {
            ListNode tmp = start;
            start = start.next;
            tmp.next = endHead;
            endHead = tmp;
        }
        ListNode dummyHead = new ListNode(1);
        ListNode cur = dummyHead;
        while (endHead != null) {
            cur.next = head;
            head = head.next;
            cur = cur.next;
            cur.next = endHead;
            endHead = endHead.next;
            cur = cur.next;
        }
        if (head != null) {
            cur.next = slowCursor;
            head.next = null;
        }
        head = dummyHead.next;
    }
    
    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4};
        ListNode listNode = ListNode.buildList(arr);
        this.reorderList(listNode);
        listNode.printList(listNode);
    }
}
