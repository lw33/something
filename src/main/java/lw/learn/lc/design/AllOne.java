package lw.learn.lc.design;

import java.util.HashMap;

/**
 * @Author lw
 * @Date 2019-02-25 21:34:11
 **/
public class AllOne {
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
    }

    HashMap<String, Node> key2node = new HashMap<>();
    HashMap<Node, NodeList> node2nodeList = new HashMap<>();

    NodeList head;
    NodeList tail;

    public AllOne() {
        head = new NodeList();
        tail = new NodeList(0, head, null);
        head.next = tail;
    }

    public void inc(String key) {
        NodeList nodeList = null;
        NodeList modifyNodeList = null;
        Node node;
        if (key2node.containsKey(key)) {
            node = key2node.get(key);
            node.times += 1;
            nodeList = node2nodeList.get(node);
            nodeList.removeNode(node);
            modifyNodeList = nodeList;
            if (nodeList.next.times == node.times) {
                nodeList = nodeList.next;
            } else {
                nodeList = addNodeList(nodeList, node.times);
            }
        } else {
            node = new Node(key, 1);
            key2node.put(key, node);
            if (head.next.times == 1) {
                nodeList = head.next;
            } else {
                nodeList = addNodeList(head, 1);
            }
        }
        nodeList.addFirst(node);
        modifyNodeList(modifyNodeList);
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

    public void dec(String key) {
        if (key2node.containsKey(key)) {
            Node node = key2node.get(key);
            NodeList nodeList = node2nodeList.get(node);
            NodeList modifyNodeList = nodeList;
            nodeList.removeNode(node);
            node.times -= 1;
            if (node.times == 0) {
                node2nodeList.remove(node);
                key2node.remove(key);
            } else if (nodeList.pre.times == node.times) {
                nodeList.pre.addFirst(node);
                node2nodeList.put(node, nodeList.pre);
            } else {
                nodeList = addNodeList(nodeList.pre, node.times);
                nodeList.addFirst(node);
                node2nodeList.put(node, nodeList);
            }
            modifyNodeList(modifyNodeList);
        }
    }

    public String getMaxKey() {
        if (key2node.isEmpty()) {
            return "";
        }
        return tail.pre.firstKey();
    }

    public String getMinKey() {
        if (key2node.isEmpty()) {
            return "";
        }
        return head.next.firstKey();
    }
}
