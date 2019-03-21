package lw.learn.p.z.linkedList;

/**
 * @Author lw
 * @Date 2019-03-21 17:52:40
 **/
public class JosephusKill {

    public class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node josephusKillI(Node head, int m) {

        if (head == null || head.next == head || m < 1) {
            return head;
        }

        Node pre = head;
        while (pre.next != head) {
            pre = pre.next;
        }
        int count = 0;
        while (pre != head) {
            if (++count == m) {
                pre.next = head.next;
                count = 0;
            } else {
                pre = pre.next;
            }
            head = pre.next;
        }
        return head;
    }
}
