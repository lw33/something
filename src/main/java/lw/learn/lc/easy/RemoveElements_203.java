package lw.learn.lc.easy;

import lw.learn.offer.util.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-09 17:49:54
 **/
public class RemoveElements_203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode faker = new ListNode(-val);
        faker.next = head;
        ListNode cur = faker;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }

        }
        return faker.next;
    }

    @Test
    public void test() {
        // 1,2,6,3,4,5,6
       /* ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(6);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next.next = new ListNode(6);*/

        //int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int[] arr = {1, 1};
        ListNode listNode = ListNode.buildList(arr);
        ListNode listNode1 = this.removeElements(listNode, 1);
        ListNode.printList(listNode1);

    }
}
