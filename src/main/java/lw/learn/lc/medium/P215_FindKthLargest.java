package lw.learn.lc.medium;


import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Author lw
 * @Date 2018-11-13 15:23:33
 **/
public class P215_FindKthLargest {

    public int findKthLargestHeap(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (heap.size() == k) {
                if (heap.peek() < num) {
                    heap.poll();
                    heap.add(num);
                }
            } else {
                heap.add(num);
            }
        }
        return heap.peek();
    }

    public int findKthLargestPartition(int[] nums, int k) {
        for (int num : nums) {
            
        }
        return 0;
    }

    @Test
    public void test() {
        System.out.println(Integer.MIN_VALUE);
    }
}
