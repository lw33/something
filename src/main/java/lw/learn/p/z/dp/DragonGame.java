package lw.learn.p.z.dp;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-26 22:47:57
 **/
public class DragonGame {

    public int minHPI(int[][] m) {

        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }

        int row = m.length;
        int col = m[0].length;

        int[][] dp = new int[row--][col--];
        dp[row][col] = m[row][col] > 0 ? 1 : -m[row][col] + 1;

        for (int j = col - 1; j >= 0; j--) {
            dp[row][j] = Math.max(1, dp[row][j + 1] - m[row][j]);
        }
        for (int i = row - 1; i >= 0; i--) {
            dp[i][col] = Math.max(1, dp[i + 1][col] - m[i][col]);
            for (int j = col - 1; j >= 0; j--) {
                int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                dp[i][j] = Math.max(min - m[i][j], 1);
            }
        }
        return dp[0][0];
    }

    public int minHPII(int[][] m) {

        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }

        int row = m.length - 1;
        int col = m[0].length;

        int[] dp = new int[col--];
        dp[col] = m[row][col] > 0 ? 1 : -m[row][col] + 1;

        for (int j = col - 1; j >= 0; j--) {
            dp[j] = Math.max(1, dp[j + 1] - m[row][j]);
        }
        for (int i = row - 1; i >= 0; i--) {
            dp[col] = Math.max(1, dp[col] - m[i][col]);
            for (int j = col - 1; j >= 0; j--) {
                int min = Math.min(dp[j], dp[j + 1]);
                dp[j] = Math.max(min - m[i][j], 1);
            }
        }
        return dp[0];
    }

    @Test
    public void test() {
        int[][] arr = {{1}};
        int[][] m = JSON2Java.json2int2Array("[[2],[1]]");
        System.out.println(this.minHPI(arr));
        System.out.println(this.minHPII(m));
    }
}
