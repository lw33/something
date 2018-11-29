package lw.learn.lc.medium;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-29 13:57:31
 **/
public class RobII_213 {

    public int rob(int[] nums) {
        if (nums.length < 4) {
            int max = 0;
            for (int num : nums) {
                if (num > max)
                    max = num;
            }
            return max;
        }
        // 去尾 抢劫 [0, n - 1]
        int[] dp1 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        int k = nums.length - 1;
        for (int i = 2; i < k; i++) {
            dp1[i] = Math.max(dp1[i - 1], nums[i] + dp1[i - 2]);
        }
        // 去头 抢劫 [1, n]
        int[] dp2 = new int[nums.length];
        dp2[k] = nums[k];
        dp2[k - 1] = Math.max(nums[k], nums[k - 1]);
        for (int i = k - 2; i > 0; i--) {
            dp2[i] = Math.max(dp1[i + 1], nums[i] + dp1[i + 2]);
        }
        return Math.max(dp1[k - 1], dp1[1]);
    }
    
    @Test
    public void test() {
        int[] arr = {1, 2, 1, 1};
        System.out.println(this.rob(arr));
    }
}
