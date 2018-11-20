package lw.learn.lc.z.stackAndQueue;

import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-11-20 14:35:35
 *
 *
 *
 **/
public class MinStack_155 {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack_155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {

            stack.push(x);
            minStack.push(x);
        } else if (minStack.peek() > x) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty())
            return 0;
        return stack.peek();
    }

    public int getMin() {
        if (stack.isEmpty())
            return 0;
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack_155 minStack = new MinStack_155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}
