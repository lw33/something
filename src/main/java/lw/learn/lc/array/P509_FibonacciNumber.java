package lw.learn.lc.array;

import org.junit.Test;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/**
 * @Author lw
 * @Date 2019-01-10 23:04:56
 **/
public class P509_FibonacciNumber {

    public int fib666(int n) {

        IntSupplier fib = new IntSupplier() {
            int pre = 0;
            int cur = 1;
            @Override
            public int getAsInt() {
                int oldValue = pre;
                this.pre = cur;
                this.cur = oldValue + cur;
                return oldValue;
            }
        };

        return IntStream.generate(fib).limit(n + 1).max().getAsInt();
    }

    @Test
    public void test() {
        System.out.println(this.fib666(2));
    }

    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int[] memo = new int[N + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= N; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[N];
    }
}
