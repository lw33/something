package lw.learn.offer;

import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-10-01 16:44:46
 *
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 **/
public class P5_StackMockQueue {

    private Stack<Integer> push = new Stack<>();
    private Stack<Integer> pop = new Stack<>();

    public void push(int node) {
        push.push(node);
    }

    public int pop() {
        if (pop.isEmpty()) {
            while (!push.isEmpty()) {
                pop.push(push.pop());
            }
        }
        return pop.pop();
    }
}
