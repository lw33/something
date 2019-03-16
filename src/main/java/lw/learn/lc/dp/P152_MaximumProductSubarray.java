package lw.learn.lc.dp;

/**
 * @Author lw
 * @Date 2019-03-01 23:56:21
 **/
public class P152_MaximumProductSubarray {

    public int maxProductI(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int mul = nums[i];
            max = Math.max(mul, max);
            for (int j = i + 1; j < nums.length; j++) {
                mul *= nums[j];
                max = Math.max(mul, max);
            }
        }
        return max;
    }

    public int maxProductII(int[] nums) {

        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmpMax = max * nums[i];
            int tmpMin = min * nums[i];
            max = Math.max(Math.max(nums[i], tmpMax), tmpMin);
            min = Math.min(Math.min(nums[i], tmpMin), tmpMax);
            res = Math.max(res, max);
        }

        return res;
    }
}
