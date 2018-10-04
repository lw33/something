package lw.learn.offer;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-03 14:22:37
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 **/
public class P47_SumWithoutArithmetic {


    public int Sum_Solution(int n) {

        int res = 0;
        boolean b = n != 0 && ((res = Sum_Solution(n - 1) + n) == 0);
        return res;
    }

    @Test
    public void test() {
        System.out.println(this.Sum_Solution(10));
    }
}
