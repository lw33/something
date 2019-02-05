package lw.learn.lc.dp;

import lw.learn.utils.LCUtils;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-22 17:14:56
 **/
public class P322_CoinChange {

    public int coinChange(int[] coins, int amount) {

        //return coinChange(coins, amount, 0);

        if (amount == 0) {
            return 0;
        }

        return 0;
    }

    public int coinChangeDP1(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[coins.length][i] = Integer.MAX_VALUE >>> 3;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                dp[j][i] = dp[j + 1][i];
                if (i >= coins[j]) {
                    dp[j][i] = Math.min(dp[j][i], 1 + dp[j][i - coins[j]]);
                }
            }
        }
        return dp[0][amount] >= (Integer.MAX_VALUE >>> 3) ? -1 : dp[0][amount];
    }

    public int coinChangeDP(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE >>> 3;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                dp[i] = dp[i];
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return dp[amount] >= (Integer.MAX_VALUE >>> 3) ? -1 : dp[amount];
    }

    public int coinChange(int[] coins, int amount, int index) {
        if (amount == 0) {
            return 0;
        }
        if (index == coins.length || amount < 0) {
            return Integer.MAX_VALUE >>> 3;
        }
        return Math.min(coinChange(coins, amount, index + 1),
                1 + coinChange(coins, amount - coins[index], index));
    }

    // [index..coins.length]
    public int coinChange(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            return count;
        }
        if (index == coins.length || amount < 0) {
            return Integer.MAX_VALUE;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i * coins[index] <= amount; i++) {
            res = Math.min(res,
                    coinChange(coins, amount - i * coins[index], index + 1, count + i));
        }

        return res;
    }

    @Test
    public void test() {
        int[] arr = LCUtils.stringToIntegerArray("[288,160,10,249,40,77,314,429]");
        int amount = 9208;
        //int[] arr = LCUtils.stringToIntegerArray("[1,2,5,10]");
        //int amount = 18;

        System.out.println(this.coinChange(arr, amount));
        System.out.println(this.coinChangeDP1(arr, amount));
        System.out.println(this.coinChangeDP(arr, amount));
    }
}
