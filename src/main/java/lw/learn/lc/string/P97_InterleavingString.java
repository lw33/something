package lw.learn.lc.string;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-16 21:26:56
 **/
public class P97_InterleavingString {

    @Test
    public void testDP() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(this.isInterleaveDP(s1, s2, s3));
    }

    public boolean isInterleaveDP(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        char[] c = s3.toCharArray();

        boolean[][] dp = new boolean[a.length + 1][b.length + 1];
        dp[0][0] = true;
        for (int i = 1; i <= a.length; i++) {
            if (dp[i - 1][0]) {
                dp[i][0] = a[i - 1] == c[i - 1];
            } else {
                break;
            }
        }

        for (int j = 1; j <= b.length; j++) {
            if (dp[0][j - 1]) {
                dp[0][j] = b[j - 1] == c[j - 1];
            } else {
                break;
            }
        }

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if ((dp[i - 1][j] && a[i - 1] == c[i + j - 1]) ||
                        (dp[i][j - 1] && b[j - 1] == c[i + j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[a.length][b.length];
    }


    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();

        return isInterleave(chars1, chars2, chars3, 0, 0, 0);
    }

    public boolean isInterleave(char[] c1, char[] c2, char[] c3, int i1, int i2, int i3) {
        if (i1 == c1.length && i2 == c2.length && i3 == c3.length) {
            return true;
        }
        if (i1 == c1.length) {
            return onlyOne(c2, c3, i2, i3);
        } else if (i2 == c2.length) {
            return onlyOne(c1, c3, i1, i3);
        }
        if (c1[i1] == c3[i3] && c2[i2] == c3[i3]) {
            return isInterleave(c1, c2, c3, i1 + 1, i2, i3 + 1) || isInterleave(c1, c2, c3, i1, i2 + 1, i3 + 1);
        } else if (c1[i1] == c3[i3]) {
            return isInterleave(c1, c2, c3, i1 + 1, i2, i3 + 1);
        } else if (c2[i2] == c3[i3]) {
            return isInterleave(c1, c2, c3, i1, i2 + 1, i3 + 1);
        } else {
            return false;
        }
    }

    private boolean onlyOne(char[] c1, char[] c3, int i1, int i3) {
        for (; i1 < c1.length; i1++) {
            if (c1[i1] != c3[i3++]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        //String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        String s1 = "ab";
        String s2 = "bc";
        String s3 = "bcab";
        System.out.println(this.isInterleave(s1, s2, s3));
    }
}
