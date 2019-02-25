package lw.learn.lc.design;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2019-01-06 22:38:29
 **/
public class P432_AllOOneDataStructure {

    class AllOneI {

        HashMap<String, Integer> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public AllOneI() {

        }

        /**
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
         */
        public void dec(String key) {
            Integer times = map.get(key);
            if (times != null) {
                if (times == 1) {
                    map.remove(key);
                } else {
                    map.put(key, times - 1);
                }
            }
        }

        /**
         * Returns one of the keys with maximal value.
         */
        public String getMaxKey() {
            int max = Integer.MIN_VALUE;
            String res = "";
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (max < entry.getValue()) {
                    max = entry.getValue();
                    res = entry.getKey();
                }
            }
            return res;
        }

        /**
         * Returns one of the keys with Minimal value.
         */
        public String getMinKey() {
            int minValue = Integer.MAX_VALUE;
            String res = "";
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (minValue > entry.getValue()) {
                    minValue = entry.getValue();
                    res = entry.getKey();
                }
            }
            return res;
        }
    }

    @Test
    public void test() {
        //["a"],["b"],["c"],["d"],["a"],["b"],["c"],["d"],["c"],["d"],["d"],["a"]
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("d");
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("d");
        allOne.inc("c");
        allOne.inc("d");
        allOne.inc("d");
        allOne.inc("a");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
        System.out.println();
    }

    /**
     * 使用两个双向链表 维护
     * 并且维护首尾节点 代码更好写
     */
    class AllOne {

        class Node {
            String key;
            int times;
            Node pre;
            Node next;

            public Node(String key, int times) {
                this(key, times, null, null);
            }

            public Node(String key) {
                this(key, 0, null, null);
            }

            public Node() {

            }

            public Node(String key, int times, Node pre, Node next) {
                this.key = key;
                this.times = times;
                this.pre = pre;
                this.next = next;
            }
        }

        class NodeList {

            int times;
            NodeList pre;
            NodeList next;

            Node head;
            Node tail;


            public NodeList() {
                this(0, null, null);
            }

            public NodeList(int times) {
                this(times, null, null);
            }

            public NodeList(int times, NodeList pre, NodeList next) {

                this.times = times;
                this.pre = pre;
                this.next = next;

                head = new Node("");
                tail = new Node("", 0, head, null);
                head.next = tail;
            }

            public boolean isEmpty() {
                return head.next == tail;
            }

            public String firstKey() {
                if (isEmpty()) {
                    return null;
                }
                return head.next.key;
            }

            public void removeNode(Node node) {
                if (isEmpty()) {
                    return;
                }
                node.next.pre = node.pre;
                node.pre.next = node.next;
            }

            public void addFirst(Node node) {
                node.next = head.next;
                node.pre = head;
                head.next.pre = node;
                head.next = node;
            }

            public Node removeLast() {
                if (isEmpty()) {
                    return null;
                }
                Node node = tail.pre;
                node.pre.next = tail;
                tail.pre = node.pre;
                return node;
            }
        }

        HashMap<String, Node> key2node = new HashMap<>();
        HashMap<Node, NodeList> node2nodeList = new HashMap<>();

        NodeList head;
        NodeList tail;


        /**
         * Initialize your data structure here.
         */
        public AllOne() {
            head = new NodeList();
            tail = new NodeList(0, head, null);
            head.next = tail;
        }

        /**
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {
            NodeList nodeList;
            NodeList modifyNodeList = null;
            Node node;
            // 有这个 key
            if (key2node.containsKey(key)) {
                // 这个 key 对应的 Node
                node = key2node.get(key);
                // 加一
                node.times += 1;
                // 找出这个 key 对应的 NodeList
                nodeList = node2nodeList.get(node);
                // 因为 times 变了 从这个 NodeList 中 删除 Node
                nodeList.removeNode(node);
                // 同样更新 Node 与 NodeList 映射
                //node2nodeList.remove(node);
                // 因为少了一个 Node 当前 NodeList 可能要被删除
                modifyNodeList = nodeList;
                // 如果当前 NodeList 的下一个 NodeList 的 times 与 Node times 相同
                if (nodeList.next.times == node.times) {
                    // 直接加入
                    nodeList.next.addFirst(node);
                    // 维护 nodeList 引用
                    nodeList = nodeList.next;
                } else {
                    // 否则需要创建一个 NodeList
                    // 并且在当前 NodeList 后面
                    nodeList = addNodeList(nodeList, node.times);
                    // 在新建的 NodeList 中加入 Node
                    nodeList.addFirst(node);
                }
            } else {
                // 不存在 key
                // 新建 Node
                node = new Node(key, 1);
                key2node.put(key, node);
                // 如果 head 的 next 的 NodeList times 为 1
                if (head.next.times == 1) {
                    // 直接加入
                    head.next.addFirst(node);
                    nodeList = head.next;
                } else {
                    // 新建一个 times 为 1 的 NodeList
                    nodeList = addNodeList(head, 1);
                    // 加入 Node
                    nodeList.addFirst(node);
                }
            }
            // 维护 NodeList 可能没有节点了 需要删除
            modifyNodeList(modifyNodeList);
            // 维护 Node2NodeList map
            node2nodeList.put(node, nodeList);
        }

        private NodeList addNodeList(NodeList pre, int times) {
            NodeList nodeList = new NodeList(times, pre, pre.next);
            pre.next.pre = nodeList;
            pre.next = nodeList;
            return nodeList;
        }

        private void modifyNodeList(NodeList nodeList) {
            if (nodeList != null) {
                if (nodeList.isEmpty()) {
                    nodeList.pre.next = nodeList.next;
                    nodeList.next.pre = nodeList.pre;
                }
            }
        }

        public void removeNodeList(NodeList nodeList) {
            nodeList.pre.next = nodeList.next;
            nodeList.next.pre = nodeList.pre;
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
         */
        public void dec(String key) {
            // 存在
            if (key2node.containsKey(key)) {
                // 得到 key 对应的 Node
                Node node = key2node.get(key);
                // 得到 Node 对应的 NodeList
                NodeList nodeList = node2nodeList.get(node);
                NodeList modifyNodeList = nodeList;
                // 从 NodeList 中删除 Node 因为 Node 的 times 变了
                nodeList.removeNode(node);
                // dec
                node.times -= 1;
                // Node 的 次数为 0
                if (node.times == 0) {
                    // 删除 key 与 Node 对应的映射关系
                    node2nodeList.remove(node);
                    key2node.remove(key);
                    // 如果前一个 times 等于 Node 的 times
                } else if (nodeList.pre.times == node.times) {
                    // 直接将当前 node 加入
                    nodeList.pre.addFirst(node);
                    node2nodeList.put(node, nodeList.pre);
                } else {
                    // 创建新 NodeList
                    nodeList = addNodeList(nodeList.pre, node.times);
                    nodeList.addFirst(node);
                    node2nodeList.put(node, nodeList);
                }
                modifyNodeList(modifyNodeList);
            }
        }

        /**
         * Returns one of the keys with maximal value.
         */
        public String getMaxKey() {
            if (key2node.isEmpty()) {
                return "";
            }
            return tail.pre.firstKey();
        }

        /**
         * Returns one of the keys with Minimal value.
         */
        public String getMinKey() {
            if (key2node.isEmpty()) {
                return "";
            }
            return head.next.firstKey();
        }
    }
}
