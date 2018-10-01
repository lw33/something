package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-10-01 14:41:17
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 **/
public class MergeTwoLists_21 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode root = new ListNode(666);
        ListNode cur = root;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
                cur = cur.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
                cur = cur.next;
            }
        }

        while (p1 != null) {
            cur.next = p1;
            p1 = p1.next;
            cur = cur.next;
        }

        while (p2 != null) {
            cur.next = p2;
            p2 = p2.next;
            cur = cur.next;
        }

        return root.next;
    }
}
