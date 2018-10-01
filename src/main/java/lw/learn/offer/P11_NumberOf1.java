package lw.learn.offer;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-01 17:18:51
 * <p>
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 **/
public class P11_NumberOf1 {

    public int NumberOf1(int n) {

        int count = 0;
        while (n != 0) {
            if ((n  & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(this.NumberOf1(-1));
        System.out.println(this.NumberOf1(10));
        System.out.println(-1>>>1);
        System.out.println(~-1);
        System.out.println(-3 % 2);
        System.out.println(3 % -2);
        System.out.println(-3%-2);
    }
}
