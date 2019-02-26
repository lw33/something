package lw.learn.p.z.dp;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-26 14:51:51
 **/
public class MinPathSum {

    public int minPathSumI(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[row - 1][col - 1];
    }

    public int minPathSumII(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[row];
        dp[0] = matrix[0][0];
        for (int i = 1; i < col; i++) {
            dp[i] = dp[i - 1] + matrix[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[0] = dp[0] + matrix[i][0];
            for (int j = 1; j < col; j++) {
                dp[j] = matrix[i][j] + Math.min(dp[j - 1], dp[j]);
            }
        }
        return dp[row - 1];
    }

    @Test
    public void test() {
        int[][] matrix = {
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}
        };
        System.out.println(this.minPathSumI(matrix));
        System.out.println(this.minPathSumII(matrix));
    }
}
