package lw.learn.lc.heap;

import java.util.PriorityQueue;

/**
 * @Author lw
 * @Date 2019-02-24 11:57:36
 **/
public class P295_FindMedianFromDataStream {

    class MedianFinder {

        int count;
        // 后一半数
        PriorityQueue<Integer> minHeap;
        // 前一半数
        PriorityQueue<Integer> maxHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((a, b) -> -Integer.compare(a, b));
        }

        public void addNum(int num) {
            if ((count & 1) == 0) {
                if (!minHeap.isEmpty() && minHeap.peek() < num) {
                    int top = minHeap.poll();
                    minHeap.add(num);
                    num = top;
                }
                maxHeap.add(num);
            } else {
                if (maxHeap.peek() > num) {
                    int top = maxHeap.poll();
                    maxHeap.add(num);
                    num = top;
                }
                minHeap.add(num);
            }
            count++;
        }

        public double findMedian() {
            if ((count & 1) == 1) {
                return maxHeap.peek();
            } else {
                return ((double) (minHeap.peek() + maxHeap.peek())) / 2;
            }
        }
    }
}
