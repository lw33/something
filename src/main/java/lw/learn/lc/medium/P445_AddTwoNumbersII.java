package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-29 13:07:54
 **/
public class P445_AddTwoNumbersII {

    /**
     * 先将两个链表反转 再相加 再将结果反转
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 反转 l1
        ListNode l1Rev = reverse(l1);
        // 反转 l2
        ListNode l2Rev = reverse(l2);
        // 设置虚拟头结点
        ListNode dummyHead = new ListNode(1);
        // 结果链表的游标
        ListNode cur = dummyHead;
        // 进位
        int carry = 0;

        // 相加
        while (l1Rev != null && l2Rev != null) {
            int i = l1Rev.val + l2Rev.val + carry;
            if (i / 10 > 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(i % 10);
            cur = cur.next;
            l1Rev = l1Rev.next;
            l2Rev = l2Rev.next;
        }

        while (l1Rev != null) {
            int i = l1Rev.val  + carry;
            if (i / 10 > 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(i % 10);
            cur = cur.next;
            l1Rev = l1Rev.next;
        }

        while (l2Rev != null) {
            int i = l2Rev.val  + carry;
            if (i / 10 > 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(i % 10);
            cur = cur.next;
            l2Rev = l2Rev.next;
        }

        // 最后一位是否有进位
        if (carry == 1) {
            cur.next = new ListNode(1);
            cur = cur.next;
        }
        // 将结果反转返回
        return reverse(dummyHead.next);
    }
    
    public ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }
    
    @Test
    public void test() {
        //7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)

        int[] arr1 = {7, 2, 4, 3};
        int[] arr2 = {5, 6, 4,8};
        ListNode l1 = ListNode.buildList(arr1);
        ListNode l2 = ListNode.buildList(arr2);
        ListNode res = this.addTwoNumbers(l1, l2);
        ListNode.printList(res);
    }
}
