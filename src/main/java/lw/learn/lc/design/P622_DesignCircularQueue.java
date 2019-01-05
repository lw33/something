package lw.learn.lc.design;

/**
 * @Author lw
 * @Date 2019-01-05 17:47:48
 **/
public class P622_DesignCircularQueue {

    class MyCircularQueue {

        private int[] queue;
        private int size;
        private int head = 0;
        private int tail = -1;


        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            queue = new int[k];
            size = 0;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            ++tail;
            tail %= queue.length;
            queue[tail] = value;
            ++size;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            ++head;
            head %= queue.length;
            --size;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (isEmpty()) {
                return -1;
            } else {
                return queue[head];
            }
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            } else {
                return queue[tail];
            }

        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size == queue.length;
        }
    }
}
