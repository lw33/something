package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-11-17 22:44:04
 **/
public class CanPartition_416 {

    private int[][] memo;

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if ((sum & 1) == 1)
            return false;

        memo = new int[nums.length][sum / 2 + 1];

        return partition(nums, nums.length - 1, sum / 2);
    }

    private boolean partition(int[] nums, int index, int c) {

        if (c == 0)
            return true;

        if (c < 0 || index < 0)
            return false;

        if (memo[index][c] != 0)
            return memo[index][c] == 1;

        memo[index][c] = partition(nums, index - 1, c) || partition(nums, index - 1, c - nums[index]) ? 1 : 2;
        return memo[index][c] == 1;
    }

    public boolean canPartitionDP(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if ((sum & 1) == 1)
            return false;

        int capacity = sum / 2;
        boolean[] dp = new boolean[capacity + 1];

        for (int i = 0; i <= capacity; i++)
            dp[i] = nums[0] == i;

        for (int i = 1; i < nums.length; i++) {
            for (int j = capacity; j >= nums[i]; j--)
                dp[j] = dp[j] || dp[j - nums[i]];

            if (dp[capacity])
                return true;
        }


        return dp[capacity];
    }
}
