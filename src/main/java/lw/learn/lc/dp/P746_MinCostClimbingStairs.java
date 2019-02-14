package lw.learn.lc.dp;

import lw.learn.utils.LCUtils;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-12 18:45:28
 **/
public class P746_MinCostClimbingStairs {

    /**
     * f(n) = min(f(n-1) + cost[n-1], f(n-2) + cost[n-2])
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 3) {
            return 0;
        }
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    @Test
    public void test() {
        int[] arr = LCUtils.stringToIntegerArray("[10, 15, 20]");
        System.out.println(this.minCostClimbingStairs(arr));
    }
}
