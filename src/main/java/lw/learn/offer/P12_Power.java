package lw.learn.offer;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-01 17:43:10
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 **/
public class P12_Power {

    public double Power(double base, int exponent) {

        if (exponent == 0) {
            return 1;
        }
        if (base == 0) {
            return 0;
        }
        boolean isNegetive = false;
        if (exponent < 0) {
            isNegetive = true;
            exponent = -exponent;
        }
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        if (isNegetive) {

            return 1 / result;
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(this.Power(2, -3));
    }

}
