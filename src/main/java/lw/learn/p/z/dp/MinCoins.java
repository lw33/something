package lw.learn.p.z.dp;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-26 15:19:42
 **/
public class MinCoins {

    public int minCoinsI(int[] arr, int aim) {

        return minCoinsI(arr, aim, 0);
    }

    private int minCoinsI(int[] arr, int aim, int index) {
        if (aim == 0) {
            return 0;
        }
        if (index == arr.length) {
            return aim == 0 ? 0 : -1;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; aim >= arr[index] * i; i++) {
            int subRes = minCoinsI(arr, aim - arr[index] * i, index + 1);
            if (subRes >= 0) {
                res = Math.min(i + subRes, res);
            }
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public int minCoinsII(int[] arr, int aim) {
        int row = arr.length + 1;
        int col = aim + 1;
        int[][] dp = new int[row][col];
        dp[arr.length][0] = 0;
        for (int i = 1; i < col; i++) {
            dp[arr.length][i] = -1;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                int res = Integer.MAX_VALUE;
                //for (int k = 0; j >= arr[i] * k; k++) {
                //    int subRes = dp[i + 1][j - arr[i] * k];
                //    if (subRes >= 0) {
                //        res = Math.min(k + subRes, res);
                //    }
                //}
                if (j >= arr[i]) {
                    if (dp[i][j - arr[i]] >= 0) {
                        res = dp[i][j - arr[i]] + 1;
                    }
                }
                if (dp[i + 1][j] >= 0) {
                    res = Math.min(res, dp[i + 1][j]);
                }
                if (res == Integer.MAX_VALUE) {
                    dp[i][j] = -1;
                } else {
                    dp[i][j] = res;
                }
            }
        }
        return dp[0][aim];
    }

    public int minCoinsIII(int[] arr, int aim) {

        int n = arr.length;
        int[][] dp = new int[n][aim + 1];

        for (int i = 1; i <= aim; i++) {
            dp[0][i] = Integer.MAX_VALUE;
            if (i >= arr[0] && dp[0][i - arr[0]] != Integer.MAX_VALUE) {
                dp[0][i] = dp[0][i - arr[0]] + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                int left = Integer.MAX_VALUE;
                if (j >= arr[i] && dp[i][j - arr[i]] != Integer.MAX_VALUE) {
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != Integer.MAX_VALUE ? dp[n - 1][aim] : -1;
    }

    public int minCoinsIV(int[] arr, int aim) {

        int n = arr.length;
        int[] dp = new int[aim + 1];

        for (int i = 1; i <= aim; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (i >= arr[0] && dp[i - arr[0]] != Integer.MAX_VALUE) {
                dp[i] = dp[i - arr[0]] + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                int left = Integer.MAX_VALUE;
                if (j >= arr[i] && dp[j - arr[i]] != Integer.MAX_VALUE) {
                    left = dp[j - arr[i]] + 1;
                }
                dp[j] = Math.min(left, dp[j]);
            }
        }
        return dp[aim] != Integer.MAX_VALUE ? dp[aim] : -1;
    }

    @Test
    public void test() {
        int[] arr = {5, 2, 5, 3};
        int aim = 15;
        System.out.println(this.minCoinsI(arr, aim));
        System.out.println(this.minCoinsII(arr, aim));
        System.out.println(this.minCoinsIII(arr, aim));
        System.out.println(this.minCoinsIV(arr, aim));
    }
}
