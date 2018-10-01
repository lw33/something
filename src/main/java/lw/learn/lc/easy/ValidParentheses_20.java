package lw.learn.lc.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-10-01 14:07:35
 **/
public class ValidParentheses_20 {
    public boolean isValid(String s) {

        if (s == null ||  s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')' );
        map.put('{', '}' );
        map.put('[', ']' );

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() || map.get(stack.peek()) != s.charAt(i)) {
                    return false;
                } else {
                    stack.pop();
                }
            }

        }

        return stack.isEmpty();
    }

    @Test
    public void test() {
        System.out.println(this.isValid("){"));
    }
}
