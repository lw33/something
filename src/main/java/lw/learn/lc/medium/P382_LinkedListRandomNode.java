package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;

import java.util.Random;

/**
 * @Author lw
 * @Date 2019-01-01 18:51:37
 **/
public class P382_LinkedListRandomNode {
    class Solution {

        private int length = 0;
        private ListNode head;
        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head = head;
            ListNode cur = head;
            while (cur != null) {
                ++length;
                cur = cur.next;
            }
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int i = new Random().nextInt(length);
            ListNode cur = head;
            while (i != 0) {
                cur = cur.next;
                --i;
            }
            return cur.val;
        }
    }
}
