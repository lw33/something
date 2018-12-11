package lw.learn.lc.easy;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-13 22:04:36
 **/
public class P206_ReverseList {

    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode newHead = null;

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
        int[] arr = {1, 2, 3};
        ListNode listNode = ListNode.buildList(arr);
        ListNode.printList(this.reverseList(listNode));
    }
}
