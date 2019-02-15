package lw.learn.lc.array;

/**
 * @Author lw
 * @Date 2019-02-14 23:39:37
 **/
public class P747_LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secMax = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                secMax = max;
                max = nums[i];
                res = i;
            } else if (max == nums[i]) {
            } else if (secMax < nums[i]) {
                secMax = nums[i];
            }
        }
        return secMax * 2 <= max ? res : -1;
    }
}
