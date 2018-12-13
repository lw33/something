package lw.learn.lc.hard;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Author lw
 * @Date 2018-12-13 22:30:53
 **/
public class P23_MergeKLists {

    class Node implements Comparable<Node>{
        int th;
        ListNode value;

        public Node(int th, ListNode value) {
            this.th = th;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return value.val - o.value.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(new Node(i,lists[i]));
            }
        }
        if (pq.isEmpty()) {
            return null;
        }
        Node minNode = pq.poll();
        ListNode root = new ListNode(minNode.value.val);
        ListNode cur = root;
        if (minNode.value.next != null) {
            pq.add(new Node(minNode.th, minNode.value.next));
        }
        while (!pq.isEmpty()) {
            minNode = pq.poll();
            if (minNode.value.next != null) {
                pq.add(new Node(minNode.th, minNode.value.next));
            }
            cur.next = minNode.value;
            cur = cur.next;
        }
        return root;
    }
    @Test
    public void test() {
        int[] l1 = {1, 4, 5};
        int[] l2 = {1, 3, 4};
        int[] l3 = {2, 6};
        ListNode list1 = ListNode.buildList(l1);
        ListNode list2 = ListNode.buildList(l2);
        ListNode list3 = ListNode.buildList(l3);
        ListNode[] listNodes = {list1, list2, list3};
        ListNode listNode = this.mergeKLists(listNodes);
        listNode.printList(listNode);
    }
}
