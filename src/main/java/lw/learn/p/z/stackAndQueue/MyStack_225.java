package lw.learn.p.z.stackAndQueue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lw
 * @Date 2018-11-20 15:07:21
 **/
public class MyStack_225 {

    class MyStack {

        Queue<Integer> data = new LinkedList<>();
        Queue<Integer> help = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            data.offer(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (data.isEmpty())
                return 0;
            while (data.size() > 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> q = data;
            data = help;
            help = q;
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (data.isEmpty())
                return 0;
            while (data.size() > 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            help.add(res);
            swap();
            return res;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return data.isEmpty();
        }
    }

    @Test
    public void test() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
    }
}
