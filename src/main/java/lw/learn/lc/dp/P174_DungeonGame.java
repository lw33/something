package lw.learn.lc.dp;

/**
 * @Author lw
 * @Date 2019-02-26 22:45:10
 **/
public class P174_DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {

        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return 0;
        }

        int row = dungeon.length;
        int col = dungeon[0].length;

        int[][] dp = new int[row--][col--];
        dp[row][col] = dungeon[row][col] > 0 ? 1 : -dungeon[row][col] + 1;

        for (int j = col - 1; j >= 0; j--) {
            dp[row][j] = Math.max(1, dp[row][j + 1] - dungeon[row][j]);
        }
        for (int i = row - 1; i >= 0; i--) {
            dp[i][col] = Math.max(1, dp[i + 1][col] - dungeon[i][col]);
            for (int j = col - 1; j >= 0; j--) {
                int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                dp[i][j] = Math.max(min - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
