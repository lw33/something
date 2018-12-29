package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-28 01:21:19
 **/
public class P147_InsertionSortList {

    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 定义虚拟头结点
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;
        /**
         *  6, 5, 3, 1, 8, 7, 2, 4
         *  new 3 <- 5 <- 6    old 1 -> 8 -> 7 -> 2 -> 4
         */
        // 新链表的前一个指针
        ListNode pre = dummyHead;
        // 新当前指针
        ListNode newCur = head;

        // 原链表当前指针
        ListNode cur = head.next;

        // 将新链表尾部指向 null
        newCur.next = null;
        while (cur != null) {

            // 原链表当前指针
            ListNode tmpCur = cur;
            cur = cur.next;

            while (true) {
                // 当链表到最后一个数时
                if (newCur.next == null && newCur.val > tmpCur.val) {
                    newCur.next = tmpCur;
                    tmpCur.next = null;
                    break;
                // 但新链表当前值大于 原链表当前值时
                } else if (newCur.val > tmpCur.val) {
                    pre = newCur;
                    newCur = newCur.next;
                } else {
                    // 插入
                    pre.next = tmpCur;
                    tmpCur.next = newCur;
                    break;
                }
            }
            // 修改指针
            newCur = dummyHead.next;
            pre = dummyHead;
        }

        ListNode newHead = null;
        cur = dummyHead.next;

        // 得出的链表为逆序 所以要逆序回去
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
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        ListNode listNode = ListNode.buildList(arr);
        ListNode listNode1 = this.insertionSortList(listNode);
        ListNode.printList(listNode1);
    }
}
