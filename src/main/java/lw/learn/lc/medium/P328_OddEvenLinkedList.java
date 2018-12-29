package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-29 21:13:29
 **/
public class P328_OddEvenLinkedList {

    /**
     * 定义一个奇链表 一个 偶链表 然后从原链表中将节点分别填入
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {

        // 当链表节点数小于2时
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        // 奇节点游标
        ListNode oddCur = head;
        // 偶节点头
        ListNode evenHead = head.next;
        // 偶节点游标
        ListNode evenCur = evenHead;
        // 原链表游标
        ListNode cur = head.next.next;
        // 当前节点是否为奇节点
        boolean flag = true;

        // 将奇链表 与 偶链表 尾设为 null
        oddCur.next = null;
        evenCur.next = null;

        while (cur != null) {
            ListNode tmpCur = cur;
            cur = cur.next;
            // 填入奇链表
            if (flag) {
                flag = false;
                oddCur.next = tmpCur;
                oddCur = oddCur.next;
                oddCur.next = null;
            } else {
                // 填入偶链表
                flag = true;
                evenCur.next = tmpCur;
                evenCur = evenCur.next;
                evenCur.next = null;
            }
        }
        // 奇偶链表连接
        oddCur.next = evenHead;
        return head;
    }

    @Test
    public void test() {
        //int[] arr = {1, 2, 3};
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.buildList(arr);
        ListNode listNode1 = this.oddEvenList(listNode);
        ListNode.printList(listNode1);

    }
}
