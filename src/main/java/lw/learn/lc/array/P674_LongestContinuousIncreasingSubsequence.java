package lw.learn.lc.array;

/**
 * @Author lw
 * @Date 2019-02-12 09:35:31
 **/
public class P674_LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2) return nums.length;
        int max = 1;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                len++;
            } else {
                max = max < len ? len : max;
                len = 1;
            }
        }
        max = max < len ? len : max;
        return max;
    }
}
