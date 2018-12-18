package lw.learn.lc.hard;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-18 15:41:53
 **/
public class P25_ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        int i = 0;
        ListNode start = head;
        ListNode end;
        while (cur != null) {
            i++;
            end = cur;
            cur = cur.next;
            if (i % k == 0) {
                end.next = null;
                pre.next = reverse(start);
                start.next = cur;
                pre = start;
                start = cur;
            }

        }
        return dummyHead.next;
    }

    public ListNode reverse(ListNode listNode) {
        ListNode newHead = null;
        ListNode cur = listNode;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.buildList(arr);
        ListNode.printList(this.reverseKGroup(listNode, 2));
    }
}
