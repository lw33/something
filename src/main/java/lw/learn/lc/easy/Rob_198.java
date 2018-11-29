package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-11-29 11:47:01
 **/
public class Rob_198 {

    int[] memo;
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
        //memo = new int[nums.length];
        //return rob(nums, 0);
    }

    // 考虑抢劫 [index...nums.length) 范围里的房子
    private int rob(int[] nums, int index) {

        if (index >= nums.length)
            return 0;
        if (memo[index] != 0)
            return memo[index];

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + rob(nums, i + 2));
        }
        memo[index] = res;
        return res;
    }
}
