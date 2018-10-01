package lw.learn.offer;

import lw.learn.offer.util.ListNode;

import java.util.ArrayList;

/**
 * @Author lw
 * @Date 2018-10-01 15:44:58
 *
 * 题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 **/
public class P3_PrintListFromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ListNode newHead = null;

        while (listNode != null) {
            ListNode tmp = listNode;
            listNode = listNode.next;
            tmp.next = newHead;
            newHead = tmp;
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (newHead != null) {
            res.add(newHead.val);
            newHead = newHead.next;
        }
        return res;
    }
}
