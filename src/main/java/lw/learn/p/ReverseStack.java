package lw.learn.p;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-10-07 12:17:00
 **/
public class ReverseStack {


    public int get(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = get(stack);
            stack.push(result);
            return last;
        }
    }

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        } else {
            int i = get(stack);
            reverse(stack);
            stack.push(i);
        }
    }


    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
}
