package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-12-29 16:44:38
 **/
public class P430_FlattenAMultilevelDoublyLinkedList {

    /**
     * 递归将下一层的尾指向当前节点 当前节点前指向下一层的尾
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        Node cur = head;
        if (cur != null) {
            tail(cur);
        }
        return head;
    }

    public Node tail(Node node) {
        // 当一层中只有一个节点 直接返回
        Node tail = node;
        while (node != null) {
            // 指向当前节点 当 node == null 时 tail 为尾节点
            tail = node;
            // 当当前节点有孩子时
            if (node.child != null) {
                // 当前节点指向下一个节点
                node = node.next;
                // 上一个节点的下一个节点为 上一个节点的孩子
                tail.next = tail.child;
                // 同理修改指针
                tail.child.prev = tail;
                // 递归调用返回尾
                Node newTail = tail(tail.child);
                // 扁平化 将孩子节点置空
                tail.child = null;
                // 如果 下一个节点为空 直接返回 尾指针
                /*     tail  node
                    1 -> 2 -> 3 -> 4 -> null
                         |
                         6 -> null
                         |
                         7 -> null
                         |
                        null
                    以应对这种情况
                 */
                if (node == null) {
                    return newTail;
                }
                // 修改指针 下一层的尾指针指向当前层节点
                newTail.next = node;
                node.prev = newTail;
                continue;
            }
            node = node.next;
        }
        return tail;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
