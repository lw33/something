package lw.learn.offer;

import lw.learn.offer.util.ListNode;

/**
 * @Author lw
 * @Date 2018-10-02 22:01:26
 * <p>
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 **/
public class P36_FindFirstCommonNode {


    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        int length1 = 0;
        int length2 = 0;
        while (cur1 != null) {
            length1++;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            length2++;
            cur2 = cur2.next;
        }

        int sub = length1 >= length2 ? length1 - length2 : length2 - length1;
        cur1 = length1 >= length2 ? pHead1 : pHead2;
        cur2 = cur1 == pHead1 ? pHead2 : pHead1;
        for (int i = 0; i < sub; i++) {
            cur1 = cur1.next;
        }

        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }

}
