package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;

import java.util.HashSet;

/**
 * @Author lw
 * @Date 2018-11-20 21:01:53
 **/
public class DetectCycle_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;
        HashSet<ListNode> nodes = new HashSet<>();
        while (cur != null) {
            if (nodes.contains(cur))
                return cur;
            else
                nodes.add(cur);
            cur = cur.next;
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
