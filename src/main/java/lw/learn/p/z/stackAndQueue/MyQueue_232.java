package lw.learn.p.z.stackAndQueue;

import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-11-20 15:17:48
 **/
public class MyQueue_232 {

    class MyQueue {

        Stack<Integer> push = new Stack<>();
        Stack<Integer> pop = new Stack<>();

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            push.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while (pop.isEmpty()) {
                if (push.isEmpty())
                    return 0;
                while (!push.isEmpty()) {
                    pop.push(push.pop());
                }
            }
            return pop.pop();
        }

        /** Get the front element. */
        public int peek() {
            while (pop.isEmpty()) {
                if (push.isEmpty())
                    return 0;
                while (!push.isEmpty()) {
                    pop.push(push.pop());
                }
            }
            return pop.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return push.isEmpty() && pop.isEmpty();
        }
    }

}
