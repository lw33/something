package lw.learn.lc.dp;

/**
 * @Author lw
 * @Date 2019-02-26 20:32:25
 **/
public class P72_EditDistance {

    public int minDistance(String word1, String word2) {

        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();

        int[][] dp = new int[a.length + 1][b.length + 1];

        for (int i = 1; i <= a.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= b.length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
            }
        }
        return dp[a.length][b.length];
    }
}
