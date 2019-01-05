package lw.learn.lc.stack.hard;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-04 21:40:15
 **/
public class P224_BasicCalculator {

    /**
     * 计算
     * @param s
     * @return
     */
    public int calculate(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        // 从零位置开始计算
        return calculate(chars, 0)[0];
    }

    /**
     * 从零位置开始计算 碰到括号就进行递归 计算时 累加和 加入 sum 值
     * 函数返回 sum 与累加到的位置
     * @param chars
     * @param index
     * @return
     */
    private int[] calculate(char[] chars, int index) {
        // 记录数字
        int pre = 0;
        // 记录符号
        char opt='s';
        // 累加和
        int sum = 0;

        while (index < chars.length && chars[index] != ')') {
            // 空格
            if (chars[index] == ' ') {
                index++;
                // 记录符号
            } else if (isOperator(chars[index])) {
                opt = chars[index++];
                // 数字
            } else if (chars[index] <= '9' && chars[index] >= '0') {
                // 积累数字
                pre = pre * 10 + chars[index++] - '0';
                // 如果后面还是数字
                if (index < chars.length && chars[index] <= '9' && chars[index] >= '0') {
                    continue;
                }
                // 不是第一位
                if (opt != 's') {
                    // 运算出结果
                    sum = calculate(sum, pre, opt);
                } else {
                    // 第一个数字时 用sum 记录
                    sum = pre;
                }
                // 置零
                pre = 0;
            } else if (chars[index] == '('){
                // 碰到括号 递归 算出括号中的内容
                int[] calculate = calculate(chars, ++index);
                // 将括号中的累加和 计入当前累加和
                sum = calculate(sum, calculate[0], opt);
                // 修改计算位置
                index = calculate[1] + 1;
            }
        }
        return new int[]{sum, index};
    }

    private int calculate(int num1, int num2, char opt) {
        switch (opt) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
                // 出现开始就是括号的情况 此时 没有符号 ((
            default:
                return num1 + num2;
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-';
    }
    
    @Test
    public void test() {
        String s = "1 + 1";
        System.out.println(this.calculate(s));
    }
}
