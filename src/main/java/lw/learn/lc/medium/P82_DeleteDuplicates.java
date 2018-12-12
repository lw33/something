package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-11 23:37:41
 **/
public class P82_DeleteDuplicates {
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(head.val + 1);
        dummyHead.next = head;
        ListNode pos = dummyHead;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur.next != null) {
            if (pre.val != cur.val && cur.val != cur.next.val) {
                pos.next = cur;
                pos = pos.next;
            }
            pre = cur;
            cur = cur.next;
        }
        pos.next = null;
        if (cur.val != pre.val) {
            pos.next = cur;
            pos = pos.next;
        }
        if (pos == dummyHead) {
            return null;
        }
        return dummyHead.next;
    }
    
    @Test
    public void test() {
        //1->2->3->3->4->4->5
        int[] arr = {1, 1};
        ListNode node = ListNode.buildList(arr);
        ListNode node1 = this.deleteDuplicates(node);
        ListNode.printList(node1);
        System.out.println(Integer.MAX_VALUE + 1);
    }
}
