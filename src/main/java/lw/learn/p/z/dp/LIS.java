package lw.learn.p.z.dp;

/**
 * @Author lw
 * @Date 2019-02-26 17:48:04
 **/
public class LIS {

    public int lisI(int[] arr) {

        int max = 0;
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
