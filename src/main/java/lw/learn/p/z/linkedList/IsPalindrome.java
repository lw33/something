package lw.learn.p.z.linkedList;

import lw.learn.lc.ds.ListNode;

import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-11-20 16:38:12
 * @tag easy
 **/
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (stack.pop() != cur.val)
                return false;
            cur = cur.next;
        }
        return true;
    }

    public boolean isPalindromeAdv(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }



        return true;
    }
}
