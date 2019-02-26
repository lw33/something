package lw.learn.p.z.dp;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-26 17:52:52
 **/
public class LCS {
    public String lcs(String str1, String str2) {

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int[][] dp = new int[chars1.length][chars2.length];
        dp[0][0] = chars1[0] == chars2[0] ? 1 : 0;
        for (int i = 1; i < chars1.length; i++) {
            if (dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = chars1[i] == chars2[0] ? 1 : 0;
            }
        }
        for (int i = 1; i < chars2.length; i++) {
            if (dp[0][i - 1] == 1) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = chars1[0] == chars2[i] ? 1 : 0;
            }
        }

        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }

        int m = chars1.length - 1;
        int n = chars2.length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;

        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = chars1[m];
                m--;
                n--;
            }
        }
        return new String(res);
    }

    @Test
    public void test() {
        String str1 = "1A2C3D4B56";
        String str2 = "B1D23CA45B6A";
        System.out.println(this.lcs(str1, str2));
    }
}
