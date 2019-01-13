package lw.learn.lc.bit;

/**
 * @Author lw
 * @Date 2019-01-13 22:09:47
 **/
public class P338_CountingBits {

    public int[] countBits(int num) {

        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int tmp = i;
            int oneCount = 0;
            while (tmp > 0) {
                oneCount += tmp & 1;
                tmp >>>= 1;
            }
            res[i] = oneCount;
        }
        return res;
    }

    public int[] countBitsDP(int num) {

        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }

}
