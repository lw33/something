package lw.learn.lc.dp;

import lw.learn.utils.LCUtils;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-05 17:00:45
 **/
public class P718_MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 0;
        }

        int[][] dp = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            dp[i][0] = A[i] == B[0] ? 1 : 0;
        }

        for (int i = 1; i < B.length; i++) {
            dp[0][i] = A[0] == B[i] ? 1 : 0;
        }
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                    }
                }
            }
        }

        return max;
    }

    public int findLength2(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 0;
        }

        int[] dp = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            dp[i] = A[0] == B[i] ? 1 : 0;
        }

        int max = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = B.length - 1; j > 0; j--) {
                if (A[i] == B[j]) {
                    dp[j] = dp[j - 1] + 1;
                    if (max < dp[j]) {
                        max = dp[j];
                    }
                } else {
                    dp[j] = 0;
                }
            }
            dp[0] = A[i] == B[0] ? 1 : 0;
        }

        return max;
    }

    /**
     * 不连续
     *
     * @param a
     * @param b
     * @param alen
     * @param blen
     * @return
     */
    private int findLength(int[] a, int[] b, int alen, int blen) {

        if (alen < 0 || blen < 0) {
            return 0;
        }
        int res;
        if (a[alen] == b[blen]) {
            res = 1 + findLength(a, b, alen - 1, blen - 1);
        } else {
            res = Math.max(findLength(a, b, alen - 1, blen),
                    findLength(a, b, alen, blen - 1));
        }
        return res;
    }

    @Test
    public void test() {
        int[] a = LCUtils.stringToIntegerArray("[0,1,1,1,1]");
        int[] b = LCUtils.stringToIntegerArray("[1,0,1,0,1]");
        System.out.println(this.findLength(a, b));
    }
}
