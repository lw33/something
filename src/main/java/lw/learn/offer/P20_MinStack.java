package lw.learn.offer;

import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-10-01 20:25:49
 *
 *题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 **/
public class P20_MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        if (stack.isEmpty()) {
            minStack.push(stack.size());
        } else {
            if (stack.get(minStack.peek()) > node) {
                minStack.push(stack.size());
            }
        }
        stack.push(node);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        if (minStack.peek() == stack.size() - 1) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek();
    }

    public int min() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.get(minStack.peek());
    }

    public static void main(String[] args) {

        P20_MinStack minStack = new P20_MinStack();
        //3,3,2,2,2,3,3,0
        minStack.push(3);
        minStack.push(3);
        minStack.push(2);
        minStack.push(2);
        minStack.push(2);
        minStack.push(3);
        minStack.push(3);
        minStack.push(0);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println();
    }
}
