package lw.learn.p.z.dp;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-26 16:54:49
 **/
public class Coins {

    public int conisI(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        return conisI(arr, 0, aim);
    }

    private int conisI(int[] arr, int index, int aim) {
        if (arr.length == index) {
            return aim == 0 ? 1 : 0;
        }
        if (aim == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; aim >= arr[index] * i; i++) {
            res += conisI(arr, index + 1, aim - arr[index] * i);
        }
        return res;
    }

    public int conisII(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; arr[0] * i <= aim; i++) {
            dp[0][arr[0] * i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                //int num = 0;
                //for (int k = 0; j >= arr[i] * k; k++) {
                //    num += dp[i - 1][j - arr[i] * k];
                //}
                //dp[i][j] = num;
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j >= arr[i] ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[arr.length - 1][aim];
    }

    @Test
    public void test() {
        int[] arr = {5, 10, 25, 1};
        int aim = 15;
        System.out.println(this.conisI(arr, aim));
    }
}
