package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;

/**
 * @Author lw
 * @Date 2018-12-14 13:07:15
 **/
public class P24_SwapPairs {

    public ListNode swapPairs(ListNode head) {
        // 虚拟头结点
        ListNode dummyHead = new ListNode(666);
        ListNode pre = dummyHead;
        // 不足二
        pre.next = head;
        ListNode cur = head;
        ListNode next;
        // cur 表示当前节点 pre 表示前一个节点 next 表示下一个节点
        // 如果最后节点为 null 或不足两个 返回
        while (cur != null && cur.next != null) {
            next = cur.next;
            pre.next = next;
            cur.next = next.next;
            next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
