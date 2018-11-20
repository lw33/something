package lw.learn.lc.z.array;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-20 13:49:08
 *
 *   164. 最大间距  hard
 **/
public class MaxGap {
    public int maxGap(int[] nums) {

        if (nums == null || nums.length < 2)
            return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        if (min == max)
            return 0;

        boolean[] hasNum = new boolean[nums.length + 1];
        int[] mins = new int[nums.length + 1];
        int[] maxs = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int bid = bucket(nums[i], nums.length, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i <= nums.length; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    private int bucket(long num, long length, long min, long max) {
        return (int) ((num - min) * length / (max - min));
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 40};
        System.out.println(this.maxGap(arr));
        System.out.println(bucket(40, arr.length, 1, 40));
    }
}
