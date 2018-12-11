package lw.learn.lc.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-11-28 21:56:25
 **/
public class P279_NumSquares {

    public int numSquares(int n) {
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        for (int a = 0; a * a <= n; a++)
            if (n == a * a)
                return 1;
        for (int a = 0; a * a <= n; a++) {
            int b = (int) (Math.sqrt(n - a * a));
            if (a * a + b * b == n && a >= 0 && b >= 0)
                return 2;
        }
        return 3;
    }

    public int numSq(int n) {

        if (n == 1)
            return 1;
        int ns = ns(n, 0);
        return ns;
    }

    public int ns(int n, int count) {
        if (n == 0)
            return count;
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            res = Math.min(res, ns(n - i * i, count + 1));
        }
        return res;
    }

    public int nums(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (i - j * j >= 0) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                j++;
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        //System.out.println(this.numSquares(4));
        System.out.println(this.numSquares(8));
        System.out.println(this.numSq(8));
        for (int i = 1; i < 1000; i++) {
            if (this.numSquares(i) != this.numSq(i)) {
                System.out.println(i);
                System.out.println("error");
                break;
            }
        }
    }
}
