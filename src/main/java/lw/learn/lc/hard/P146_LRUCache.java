package lw.learn.lc.hard;

import java.util.HashMap;

/**
 * @Author lw
 * @Date 2018-11-08 11:50:31
 **/
public class P146_LRUCache {

    private class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
            this(0, 0);
        }
    }

        private Node head;
        private Node tail;

        public void add(Node node) {
            if (node == null)
                return;
            if (head == null) {
                head = tail = node;
            } else {
                node.next = head;
                head.pre = node;
                node.pre = null;
                head = node;
            }
        }

        private void move2head(Node node) {
            if (node == null || head == node)
                return;
            if (tail == node) {
                tail = tail.pre;
                tail.next = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            node.next = head;
            node.pre = null;
            head.pre = node;
            head = node;
        }

        private Node removeTail() {
            Node res = tail;
            if (head == null || tail == head) {
                head = tail = null;
                return res;
            }
            tail = tail.pre;
            tail.next = null;
            res.pre = null;
            return res;
        }


    private HashMap<Integer, Node> keyNodeMap;
    private int capacity;

    public P146_LRUCache(int capacity) {
        this.capacity = capacity;
        keyNodeMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = keyNodeMap.get(key);
        if (node == null)
            return -1;
        move2head(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = keyNodeMap.get(key);
        if (node != null) {
            node.value = value;
            move2head(node);
        } else {
            if (keyNodeMap.size() == capacity) {
                keyNodeMap.remove(removeTail().key);
            }
            node = new Node(key, value);
            add(node);
            keyNodeMap.put(key, node);
        }
    }


    public static void main(String[] args) {
        /*
         * ["LRUCache","put","put","get","put","get","put","get","get","get"]
         * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
         *
         */

        P146_LRUCache lruCache_146 = new P146_LRUCache(2);
        lruCache_146.put(1, 1);
        lruCache_146.put(2, 2);
        System.out.println(lruCache_146.get(1));
        lruCache_146.put(3, 3);
        System.out.println(lruCache_146.get(2));
        lruCache_146.put(4, 4);
        System.out.println(lruCache_146.get(1));
        lruCache_146.get(3);
        lruCache_146.get(4);

    }
}
