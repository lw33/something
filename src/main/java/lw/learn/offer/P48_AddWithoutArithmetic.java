package lw.learn.offer;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-03 15:37:45
 * <p>
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 **/
public class P48_AddWithoutArithmetic {

    public int Add(int num1, int num2) {

        while (num2 != 0) {

            int res = num1 ^ num2;
            int carry = num1 & num2;
            num1 = res;
            num2 = carry << 1;
        }

        return num1;
    }

    @Test
    public void test() {
        System.out.println(this.Add(1,10));
    }
}
