package lw.learn.lc.design;


import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Author lw
 * @Date 2019-01-25 10:02:16
 **/
public class P703_KthLargestElementInAStream {

    class KthLargest {

        private PriorityQueue<Integer> priorityQueue;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            priorityQueue = new PriorityQueue<>(k);
            for (int num : nums) {
                if (priorityQueue.size() < k) {
                    priorityQueue.add(num);
                } else {
                    if (priorityQueue.peek() < num) {
                        priorityQueue.poll();
                        priorityQueue.add(num);
                    }
                }
            }
        }

        public int add(int val) {

            if (priorityQueue.size() < k) {
                priorityQueue.add(val);
                return -1;
            } else {
                if (priorityQueue.peek() < val) {
                    priorityQueue.poll();
                    priorityQueue.add(val);
                }
            }
            return priorityQueue.peek();
        }
    }

    @Test
    public void test() {
        //["KthLargest", "add", "add", "add", "add", "add"]
        //[[3,[4, 5, 8, 2]],[3],[5],[10],[9],[4]]
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>(1);
        pq.add(1);
        pq.add(2);
        System.out.println(pq);
    }
}
