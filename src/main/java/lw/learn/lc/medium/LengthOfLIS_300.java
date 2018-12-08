package lw.learn.lc.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-11-17 16:07:38
 **/
public class LengthOfLIS_300 {

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        int[] lis = new int[nums.length];
        int max = 1;
        Arrays.fill(lis, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[j] + 1, lis[i]);
                }
            }
            if (lis[i] > max)
                max = lis[i];
        }

        return max;
    }

    @Test
    public void test() {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(this.lengthOfLIS(arr));
    }
}
