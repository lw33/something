package lw.learn.p.z.stackAndQueue;


import org.junit.Test;

import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-12-18 22:05:35
 **/
public class ReverseStack {


    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = removeLast(stack);
        reverse(stack);
        stack.push(i);
    }

    public int removeLast(Stack<Integer> stack) {
        Integer pop = stack.pop();
        if (stack.isEmpty()) {
            return pop;
        }
        int reverse = removeLast(stack);
        stack.push(pop);
        return reverse;
    }

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        reverse(stack);
        System.out.println(stack);
    }
}
