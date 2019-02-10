package lw.learn.lc.dp;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-02-05 09:18:04
 **/
public class P377_CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += combinationSum4(nums, target - num);
            }
        }
        return res;
    }

    int[] memo;

    public int combinationSum4_Memo(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return combinationSum(nums, target);
    }

    public int combinationSum(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (memo[target] != -1) {
            return memo[target];
        }

        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += combinationSum4(nums, target - num);
            }
        }
        memo[target] = res;
        return res;
    }

    public int combinationSum4DP(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
