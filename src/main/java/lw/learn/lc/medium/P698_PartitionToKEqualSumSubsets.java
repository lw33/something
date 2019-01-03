package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2019-01-01 23:39:54
 **/
public class P698_PartitionToKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) {
            return false;
        }
        //int sum = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        boolean[] used = new boolean[nums.length];

        return canPartitionKSubsets(nums, used, target, k, 0, 0);
    }

    private boolean canPartitionKSubsets(int[] nums, boolean[] used, int target, int k, int index, int curSum) {
        if (k == 0)
            return true;

        if (curSum == target)
            return canPartitionKSubsets(nums, used, target, k - 1, 0, 0);

        for (int i = index; i < nums.length; i++) {
            if (used[i])
                continue;

            used[i] = true;

            if (nums[i] + curSum <= target && canPartitionKSubsets(nums, used, target, k, i + 1, curSum + nums[i])) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }


}
