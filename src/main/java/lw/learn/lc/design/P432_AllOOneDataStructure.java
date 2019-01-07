package lw.learn.lc.design;

/**
 * @Author lw
 * @Date 2019-01-06 22:38:29
 **/
public class P432_AllOOneDataStructure {

    class AllOne {

        class Node {
            String key;
            int value;
            Node pre;
            Node next;
        }

        class LinkedList {
            Node head;
            Node tail;
            public void add(Node node) {
                if (head == null) {
                    head = tail = node;
                } else {
                    node.next = head;
                    head.pre = node;
                    head = node;
                }
            }

            public void remove(Node node) {
                if (head == node) {
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        head = head.next;
                        head.pre = null;
                        node.next = null;
                    }
                } else if (tail == node) {
                    tail = tail.pre;
                    tail.next = null;
                    node.pre = null;
                } else {
                    node.next.pre = node.pre;
                    node.pre.next = node.next;
                    node.next = null;
                    node.pre = null;
                }
            }
        }

        class LinkedListNode {
            LinkedList pre;
            LinkedList next;
            int value;

            
        }


        /** Initialize your data structure here. */
        public AllOne() {

        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {

        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {

        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {

            return "";
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            return "";
        }
    }
}
