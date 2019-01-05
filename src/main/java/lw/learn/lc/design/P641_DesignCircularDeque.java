package lw.learn.lc.design;

/**
 * @Author lw
 * @Date 2019-01-05 18:52:46
 **/
public class P641_DesignCircularDeque {

    class MyCircularDeque {
        private int[] queue;
        private int size;
        private int head = 0;
        private int tail = 0;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            queue = new int[k];
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                head = tail = 0;
            } else {
                head = head == 0 ? queue.length - 1 : head - 1;
            }
            queue[head] = value;
            ++size;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                head = tail = 0;
            } else {
                tail = tail == queue.length - 1 ? 0 : tail + 1;
            }
            queue[tail] = value;
            ++size;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head = head == queue.length - 1 ? 0 : head + 1;
            --size;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail = tail == 0 ? queue.length - 1 : tail - 1;
            --size;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            } else {
                return queue[head];
            }
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            } else {
                return queue[tail];
            }
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return size == queue.length;
        }
    }

}
