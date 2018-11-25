package lw.learn.p.z.linkedList;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-20 23:17:40
 **/
public class FindFirstIntersectNode {

    public ListNode getIntersectNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        ListNode loopNode1 = getLoopNode(head1);
        ListNode loopNode2 = getLoopNode(head2);
        if (loopNode1 == null && loopNode2 == null) {
            return noLoopIntersectNode(head1, head2);
        }
        if (loopNode1 != null && loopNode2 != null) {
            return loopIntersectNode(loopNode1, head1, loopNode2, head2);
        }
        return null;
    }

    private ListNode loopIntersectNode(ListNode loopNode1, ListNode head1, ListNode loopNode2, ListNode head2) {

        if (loopNode1 == loopNode2) {

            return getIntersectNode(head1, head2, loopNode1);

        } else {

            ListNode cur = loopNode1.next;
            while (cur != loopNode1) {
                if (cur == loopNode2) {
                    return loopNode1;
                }
                cur = cur.next;
            }
            return null;
        }
    }

    private ListNode noLoopIntersectNode(ListNode head1, ListNode head2) {
        return getIntersectNode(head1, head2, null);
    }

    private ListNode getIntersectNode(ListNode head1, ListNode head2, ListNode end) {
        int n = 0;
        ListNode end1 = null;
        ListNode end2 = null;
        ListNode cur = head1;
        while (cur != end) {
            n++;
            end1 = cur;
            cur = cur.next;
        }

        cur = head2;

        while (cur != end) {
            n--;
            end2 = cur;
            cur = cur.next;
        }

        if (end1 != end2)
            return null;
        cur = head1;
        head1 = n < 0 ? head2 : head1;
        head2 = head1 == head2 ? cur : head2;
        n = Math.abs(n);
        for (int i = 0; i < n; i++) {
            head1 = head1.next;
        }
        while (head1 != end) {
            if (head2 == head1)
                return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        return end;
    }

    private ListNode getLoopNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                return fast;
            }
        }

        return null;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode[] listNodes = ListNode.buildListArr(arr);
        listNodes[5].next = listNodes[2];
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        l2.next = listNodes[2];
        System.out.println(this.getIntersectNode(l1, listNodes[0]).val);
    }
}
