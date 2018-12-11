package lw.learn.lc.medium;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-15 21:09:34
 **/
public class P343_IntegerBreak {

    private int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        breakInteger(n);
        return memo[n];
    }

    public int breakInteger(int n) {

        if(n == 1)
            return 1;

        if (memo[n] != 0)
            return memo[n];

        int res = -1;

        for (int i = 1; i <= n - 1; i++)
            res = Math.max(Math.max(res, i * (n - i)), i * breakInteger(n - i));

        memo[n] = res;
        return res;
    }


    public int integerBreak1(int n) {

        memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i - 1; j++)
                // j + i - j
                memo[i] = Math.max(Math.max(memo[i], j * (i - j)), j * memo[i - j]);
        return memo[n];
    }

    @Test
    public void test() {
        System.out.println(this.integerBreak(2));
    }
}
