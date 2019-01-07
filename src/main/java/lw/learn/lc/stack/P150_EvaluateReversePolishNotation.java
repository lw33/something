package lw.learn.lc.stack;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-04 17:43:11
 **/
public class P150_EvaluateReversePolishNotation {

    /**
     * 碰到 运算符 取出栈中两个数 运算 再将结果入栈
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {

        if (tokens.length == 0) {
            return 0;
        }

        int[] stack = new int[tokens.length];
        int index = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i])) {
                int num2 = stack[--index];
                int num1 = stack[--index];
                int eval = eval(num1, num2, tokens[i]);
                stack[index++] = eval;
            } else {
                stack[index++] = str2int(tokens[i]);
            }
        }
        return stack[0];
    }

    /**
     * string to int
     * @param s
     * @return
     */
    private int str2int(String s) {
        int pre = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        boolean flag = false;
        if (chars[i] == '-') {
            flag = true;
            ++i;
        }
        for (; i < chars.length; i++) {
            pre = pre * 10 + chars[i] - '0';
        }
        if (flag) {
            pre = -pre;
        }
        return pre;
    }

    private boolean isOperator(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }

    private int eval(int num1, int num2, String operator) {

        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }

    @Test
    public void test() {
        String[] strs = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(this.evalRPN(strs));
    }
}
