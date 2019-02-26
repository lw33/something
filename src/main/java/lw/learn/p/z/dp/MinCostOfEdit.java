package lw.learn.p.z.dp;

/**
 * @Author lw
 * @Date 2019-02-26 20:33:20
 **/
public class MinCostOfEdit {

    /**
     * 将 str1 编辑成 str2
     *
     * @param str1
     * @param str2
     * @param ic   增加代价
     * @param dc   删除代价
     * @param rc   改变代价
     * @return
     */
    public int minCostI(String str1, String str2, int ic, int dc, int rc) {

        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();

        int[][] dp = new int[a.length + 1][b.length + 1];

        for (int i = 1; i <= a.length; i++) {
            dp[i][0] = i * dc;
        }

        for (int i = 1; i <= b.length; i++) {
            dp[0][i] = i * ic;
        }

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
            }
        }

        return dp[a.length][b.length];
    }
}
