package lw.learn.lc.hard;

/**
 * @Author lw
 * @Date 2018-12-18 13:10:44
 * @tag hard
 **/
public class P32_LongestValidParentheses {

    public int longestValidParentheses(String s) {

        if (s == null || s.length() < 2) {
            return 0;
        }

        int[] dp = new int[s.length()];
        int max = 0;
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }
            int pre = i - dp[i - 1] - 1;
            if (pre >= 0 && s.charAt(pre) == '(') {
                dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
