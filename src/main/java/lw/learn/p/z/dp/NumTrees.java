package lw.learn.p.z.dp;

/**
 * @Author lw
 * @Date 2019-03-14 11:53:29
 **/
public class NumTrees {

    public int numTrees(int n) {
        if (n < 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
