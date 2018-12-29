package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-29 13:21:55
 **/
public class P725_SplitLinkedListInParts {

    /**
     * 先得出链表的长度 然后求出 每块的长度 和多余的长度
     * 每次得一块的长度与 1 知道多余的长度减为 0
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode root, int k) {

        if (root == null) {
            return new ListNode[k];
        }
        // 原链表游标
        ListNode cur = root;
        // 原链表长度
        int length = 0;
        while (cur != null) {
            ++length;
            cur = cur.next;
        }
        cur = root;
        ListNode[] kListNode = new ListNode[k];
        // 每块长度
        int everyLen = length / k;
        // 多余的长度
        int extra = length % k;
        // 数组索引
        int index = 0;
        while (cur != null) {
            // 如果 cur 不为 null 则此节点为 数组当前索引的头
            kListNode[index++] = cur;
            ListNode tmpCur = cur;
            cur = cur.next;
            // 将尾置为 null
            tmpCur.next = null;
            // 如果每块的长度为0 直接进入下次循环
            if (everyLen == 0) {
                continue;
            }

            // 减去头
            int everyLenTmp = everyLen - 1;
            // 得出 everyLen - 1 的节点
            while (everyLenTmp > 0) {
                --everyLenTmp;
                tmpCur.next = cur;
                cur = cur.next;
                tmpCur = tmpCur.next;
                tmpCur.next = null;
            }
            // 前面的数组可以有 多一个节点 如果多余节点还有的话
            if (extra > 0) {
                --extra;
                tmpCur.next = cur;
                cur = cur.next;
                tmpCur = tmpCur.next;
                tmpCur.next = null;
            }
        }

        return kListNode;
    }
    
    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ListNode listNode = ListNode.buildList(arr);
        ListNode[] listNodes = this.splitListToParts(listNode, 3);
        for (ListNode node : listNodes) {
            ListNode.printList(node);
        }
    }
}
