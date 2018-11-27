package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-11-25 14:48:22
 **/
public class MaxSubArray_53 {
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int max = nums[0];
        int cur = 0;

        for (int i = 0; i < nums.length; i++) {
            if (cur < 0) {
                cur = nums[i];
            } else {
                cur += nums[i];
            }
            max = Math.max(cur, max);
        }
        return max;
    }
}
