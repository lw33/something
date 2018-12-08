package lw.learn.lc.medium;

import lw.learn.offer.util.RandomListNode;
import org.junit.Test;

import java.util.HashMap;

/**
 * @Author lw
 * @Date 2018-11-20 20:25:51
 **/
public class CopyRandomList_138 {

    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public RandomListNode copyRandomList1(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode copyNode = new RandomListNode(cur.label);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = copyNode.next;
        }
        cur = head;

        while (cur != null) {
            RandomListNode copyNode = cur.next;
            //if (cur.random != null)
            //    copyNode.random = cur.random.next;
            copyNode.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode newHead = cur.next;
        RandomListNode newCur = newHead;
        while (newCur.next != null) {
            cur.next = newCur.next;
            cur = cur.next;
            newCur.next = cur.next;
            newCur = newCur.next;
        }
        cur.next = null;
        return newHead;
    }
    @Test
    public void test() {
        RandomListNode root = new RandomListNode(-1);
        this.copyRandomList1(root);
    }
}
