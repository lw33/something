package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-11-28 23:37:24
 **/
public class P62_UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsI(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return uniquePathsI(m - 1, n) + uniquePathsI(m, n - 1);
    }

    int[][] memo = new int[110][110];
    public int uniquePathsII(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        if (memo[m][n] != 0)
            return memo[m][n];
        memo[m][n] = uniquePathsI(m - 1, n) + uniquePathsI(m, n - 1);
        return memo[m][n];
    }
    public static int[][] grid = new int[110][110];

    public int uniquePathsIII(int m, int n) {

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                if (i == 1 || j == 1)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j-1] + grid[i-1][j];
            }
        }
        return grid[n][m];
    }
}
