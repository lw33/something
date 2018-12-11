package lw.learn.lc.easy;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-20 20:14:09
 * @tag easy
 **/
public class P141_HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    @Test
    public void test() {
        int[] arr = {1, 3};
        final ListNode listNode = ListNode.buildList(arr);
        this.hasCycle(listNode);
    }
}
