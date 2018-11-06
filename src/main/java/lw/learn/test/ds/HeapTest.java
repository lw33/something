package lw.learn.test.ds;

import lw.learn.ds.MaxHeap;
import org.junit.Test;

import java.util.Random;

/**
 * @Author lw
 * @Date 2018-11-05 22:05:02
 **/
public class HeapTest {

    @Test
    public void test1() {
        int n = 100;
        MaxHeap<Integer> heap = new MaxHeap<>();
        for (int i = 0; i < n; i++) {
            heap.add(new Random().nextInt(n));
        }
        for (int i = 0; i < n; i++) {
            System.out.print(heap.extractMax() + " ");
        }
    }
}
