package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-06 22:53:52
 **/
public class P86_Partition {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode less = new ListNode(0);
        ListNode newHead = less;
        ListNode notLess = new ListNode(0);
        ListNode notLessHead = notLess;
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = head;
            } else {
                notLess.next = head;
                notLess = head;
            }
            head = head.next;
        }
        notLess.next = null;
        less.next = notLessHead.next;
        return newHead.next;
    }
    
    @Test
    public void test() {
        //1->4->3->2->5->2
        int[] arr = {1, 4, 3, 2, 5, 2};
        ListNode node = ListNode.buildList(arr);
        ListNode partition = this.partition(node, 3);
        ListNode.printList(partition);
    }
}
