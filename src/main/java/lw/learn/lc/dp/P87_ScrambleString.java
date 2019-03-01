package lw.learn.lc.dp;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-03-01 20:09:10
 **/
public class P87_ScrambleString {

    int[][][] memo;
    char[] str1;
    char[] str2;

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        str1 = s1.toCharArray();
        str2 = s2.toCharArray();
        memo = new int[str1.length][str1.length][str1.length + 1];

        return dfs(0, 0, str1.length) == 1;
    }

    private int dfs(int s1Index, int s2Index, int len) {
        if (len == 1) {
            memo[s1Index][s2Index][len] = str1[s1Index] == str2[s2Index] ? 1 : 2;
        }
        if (memo[s1Index][s2Index][len] != 0) {
            return memo[s1Index][s2Index][len];
        }
        for (int i = 1; i < len; i++) {
            int resL = dfs(s1Index, s2Index, i);
            int resR = dfs(s1Index + i, s2Index + i, len - i);
            if (resL == 1 && resR == 1) {
                memo[s1Index][s2Index][len] = 1;
                return 1;
            }
            resL = dfs(s1Index, s2Index + len - i, i);
            resR = dfs(s1Index + i, s2Index, len - i);
            if (resL == 1 && resR == 1) {
                memo[s1Index][s2Index][len] = 1;
                return 1;
            }
        }

        memo[s1Index][s2Index][len] = 2;
        return 2;
    }

    @Test
    public void test() {
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(this.isScramble(s1, s2));
    }
}
