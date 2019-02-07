package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-29 16:41:58
 **/
public class P148_SortList {

    /**
     * 归并
     * 使用快慢指针找到中点
     * 对两边进行递归
     * 最后归并结果
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode fNode = head;
        ListNode sNode = head;
        ListNode mid = head;
        while (fNode != null && fNode.next != null) {
            fNode = fNode.next.next;
            mid = sNode;
            sNode = sNode.next;
        }
        mid.next = null;
        ListNode lHead = sortList(head);
        ListNode rHead = sortList(sNode);
        return merge(lHead, rHead);
    }

    private ListNode merge(ListNode lHead, ListNode rHead) {

        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;

        while (lHead != null && rHead != null) {
            if (lHead.val > rHead.val) {
                cur.next = rHead;
                rHead = rHead.next;
            } else {
                cur.next = lHead;
                lHead = lHead.next;
            }
            cur = cur.next;
        }

        while (lHead != null) {
            cur.next = lHead;
            lHead = lHead.next;
            cur = cur.next;
        }

        while (rHead != null) {
            cur.next = rHead;
            rHead = rHead.next;
            cur = cur.next;
        }

        return dummyHead.next;
    }

    @Test
    public void test() {
        int[] arr = {4, 2, 1, 3, 700, 1, 25};
        ListNode listNode = ListNode.buildList(arr);
        ListNode sortList = this.sortList(listNode);
        ListNode.printList(sortList);
    }
}
