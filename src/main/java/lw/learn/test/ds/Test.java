package lw.learn.test.ds;

import lw.learn.ds.DenseGraph;
import lw.learn.ds.SparseGraph;
import lw.learn.lc.ds.ListNode;

import java.util.Random;

/**
 * @Author lw
 * @Date 2018-11-05 22:20:16
 **/
public class Test {

    @org.junit.Test
    public void test() {

        int n = 20;
        int m = 100;
        SparseGraph sparseGraph = new SparseGraph(20, false);
        for (int i = 0; i < m; i++) {
            sparseGraph.addEdge(new Random().nextInt(20), new Random().nextInt(20));
        }
        long start = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            sparseGraph.iterator(i).forEachRemaining(w -> System.out.print(w + " "));
            System.out.println();
        }

        long end = System.currentTimeMillis();
        System.out.println("SparseGraph: " + (end - start));

        DenseGraph denseGraph = new DenseGraph(20, false);
        for (int i = 0; i < m; i++) {
            denseGraph.addEdge(new Random().nextInt(20), new Random().nextInt(20));
        }
        start = System.currentTimeMillis();


        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            denseGraph.iterator(i).forEachRemaining(w -> System.out.print(w + " "));
            System.out.println();
        }

        end = System.currentTimeMillis();
        System.out.println("DenseGraph: " + (end - start));


    }
    @org.junit.Test
    public void test2() {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.buildList(arr);
        ListNode.printList(listNode);
        ListNode reverse = ListNode.reverse(listNode);
        ListNode.printList(reverse);
        ListNode reverse1 = ListNode.reverse(reverse);
        ListNode.printList(reverse1);
    }
}
