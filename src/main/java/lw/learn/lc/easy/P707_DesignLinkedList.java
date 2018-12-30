package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-29 16:42:59
 **/
public class P707_DesignLinkedList {

    /**
     * ["MyLinkedList","addAtHead","addAtIndex","addAtIndex","addAtTail","addAtHead","addAtIndex","addAtIndex","addAtIndex","addAtTail","addAtTail","deleteAtIndex"]
     * [[],[0],[1,9],[1,5],[7],[1],[5,8],[5,2],[3,0],[1],[0],[6]]
     */

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(0);
        linkedList.addAtIndex(1, 9);
        linkedList.addAtIndex(1, 5);
        linkedList.addAtTail(7);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(5, 8);
        linkedList.addAtIndex(5, 2);
        linkedList.addAtIndex(3, 0);
        linkedList.addAtTail(1);
        linkedList.addAtTail(0);
        linkedList.deleteAtIndex(6);
        linkedList.deleteAtIndex(6);
        linkedList.deleteAtIndex(6);
        linkedList.deleteAtIndex(6);
        linkedList.addAtIndex(1, 9);
        linkedList.addAtIndex(1, 9);
        linkedList.addAtIndex(1, 9);
        linkedList.addAtIndex(1, 9);
    }
    static class MyLinkedList {

        class Node {
            Node next;
            Node pre;
            int val;

            public Node(int val) {
                this.val = val;
            }

            public Node(int val, Node node) {
                this.next = node;
                this.val = val;
            }

            public Node(int val, Node pre, Node next) {
                this.val = val;
                this.pre = pre;
                this.next = next;
            }
        }

        private Node head = null;
        private Node tail = null;
        private int size = 0;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {

            Node node = getNode(index);
            return node == null ? -1 : node.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            if (head == tail) {
                head = new Node(val, tail);
                if (tail == null) {
                    tail = head;
                } else {
                    tail.pre = head;
                    head.next = tail;
                }
            } else {
                head = new Node(val, head);
                head.next.pre = head;
            }
            ++size;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            if (head == null) {
                head = tail = new Node(val);
            } else {
                Node newTail = new Node(val);
                tail.next = newTail;
                newTail.pre = tail;
                tail = newTail;
            }
            ++size;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                --size;
            } else if (index == size) {
                addAtTail(val);
                --size;
            } else {
                Node node = getNode(index);
                if (node == null) {
                    return;
                }
                //node.pre.next = new Node(val, node.pre, node);
                Node newNode = new Node(val);
                newNode.next = node;
                newNode.pre = node.pre;
                node.pre.next = newNode;
                node.pre = newNode;
            }
            ++size;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {

            if (index < 0 || index >= size) {
                return;
            }
            if (head == tail) {
                head = tail = null;
            } else {
                if (index == 0) {
                    Node tmpHead = head;
                    head = head.next;
                    head.pre = null;
                    tmpHead.next = null;
                } else if (index == size - 1) {
                    Node tmpTail = tail;
                    tail = tail.pre;
                    tail.next = null;
                    tmpTail.pre = null;
                } else {
                    Node node = getNode(index);
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
            }
            --size;
        }

        private Node getNode(int index) {
            if (index < 0 || index >= size) {
                return null;
            }
            if (index == 0) {
                return head;
            } else if (index == size - 1) {
                return tail;
            } else {
                Node cur = head;
                while (index != 0) {
                    cur = cur.next;
                    --index;
                }
                return cur;
            }
        }
    }
}
