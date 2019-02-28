package lw.learn.lc.dp;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-27 22:30:51
 **/
public class P115_DistinctSubsequences {

    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        if (s.equals(t)) {
            return 1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;

        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = dp[0][0];
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[str1.length - 1][str2.length - 1];
    }

    @Test
    public void test() {

        String s1 = "rabbbitt";
        String s2 = "rabbit";

        System.out.println(this.numDistinct(s1, s2));
    }
}
