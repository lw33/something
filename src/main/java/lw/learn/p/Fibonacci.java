package lw.learn.p;

import org.junit.Test;


/**
 * @Author lw
 * @Date 2018-11-15 19:44:40
 **/
public class Fibonacci {

    public int fib1(int n) {

        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fib1(n - 1) + fib1(n - 2);
    }

    @Test
    public void test() {
        System.out.println(fib1(40));
    }
}
