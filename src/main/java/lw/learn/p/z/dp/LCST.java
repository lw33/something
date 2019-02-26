package lw.learn.p.z.dp;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-26 19:46:02
 **/
public class LCST {

    public String lcsTI(String str1, String str2) {

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[][] dp = new int[chars1.length][chars2.length];

        for (int i = 0; i < chars1.length; i++) {
            dp[i][0] = chars1[i] == chars2[0] ? 1 : 0;
        }

        for (int i = 1; i < chars2.length; i++) {
            dp[0][i] = chars1[0] == chars2[i] ? 1 : 0;
        }

        int end = 0;
        int max = 0;

        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        end = i;
                        max = dp[i][j];
                    }
                }
            }
        }

        return str1.substring(end - max + 1, end + 1);
    }

    @Test
    public void test() {
        String str1 = "abcde";
        String str2 = "bebcd";
        System.out.println(this.lcsTI(str1, str2));
    }
}
