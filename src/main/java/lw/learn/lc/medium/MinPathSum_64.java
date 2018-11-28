package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-11-28 20:06:38
 **/
public class MinPathSum_64 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int x = grid.length;
        int y = grid[0].length;
        int[][] dp = new int[x][y];
        dp[x - 1][y - 1] = grid[x - 1][y - 1];
        for (int i = y - 2; i >= 0; i--) {
            dp[x - 1][i] = grid[x - 1][i] + dp[x - 1][i + 1];
        }
        for (int i = x - 2; i >= 0; i--) {
            dp[i][y - 1] = grid[i][y - 1] + dp[i + 1][y - 1];
        }

        for (int i = x - 2; i >= 0; i--) {
            for (int j = y - 2; j >= 0 ; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        //int res = minPathSum(grid, 0, 0, 0);
        return dp[0][0];
    }

    private int minPathSum(int[][] grid, int x, int y, int sum) {

        if (x == grid.length - 1 && y == grid[0].length - 1) {
            sum += grid[x][y];
            return sum;
        }
        if (x == grid.length - 1) {
            return minPathSum(grid, x, y + 1, grid[x][y] + sum);
        } else if (y == grid[0].length - 1) {
            return minPathSum(grid, x + 1, y, grid[x][y] + sum);
        } else {
            int right = minPathSum(grid, x, y + 1, grid[x][y] + sum);
            int down = minPathSum(grid, x + 1, y, grid[x][y] + sum);
            return Math.min(right, down);
        }
    }

}
