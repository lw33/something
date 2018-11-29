package lw.learn.lc.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-11-29 00:57:18
 **/
public class UniquePathsWithObstacles_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        boolean one = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                one = true;
            dp[i][0] = one ? 0 : 1;
        }
        one = false;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                one = true;
            dp[0][i] = one ? 0 : 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    public int uniquePathsWithObstaclesI(int[][] obstacleGrid) {
        return 0;
    }
    int[][] grid = new int[110][110];
    public int uniquePath(int[][] obstacleGrid, int m, int n) {
        if (obstacleGrid[m][n] == 1) {
            return 0;
        }
        if (grid[m][n] != -1)
            return grid[m][n];
        if (m == 0 || n == 0)

        grid[m][n] = uniquePath(obstacleGrid, m - 1, n) + uniquePath(obstacleGrid, m, n - 1);
        return grid[m][n];
    }


    @Test
    public void test() {
        int[][] arr = {{1, 0}};
        System.out.println(this.uniquePathsWithObstacles(arr));
    }
}
