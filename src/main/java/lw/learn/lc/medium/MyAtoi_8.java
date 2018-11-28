package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-11-28 21:12:37
 **/
public class MyAtoi_8 {

    public int myAtoi(String str) {

        return 0;
    }

    int[] memo;
    int bi(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != 0)
            return memo[n];
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(Math.max(res, i * (n - i)), i * bi(n - i));
        }
        memo[n] = res;

        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                memo[i] = Math.max(Math.max(memo[i], j * (i - j)), j * memo[i - j]);
            }
        }
        return res;
    }
}
