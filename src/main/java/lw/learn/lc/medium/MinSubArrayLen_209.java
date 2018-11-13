package lw.learn.lc.medium;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-13 16:08:06
 **/
public class MinSubArrayLen_209 {

    public int minSubArrayLen(int s, int[] nums) {

        int l = 0;
        int r = -1;      // [l...r]
        int sum = 0;
        int res = nums.length + 1;

        while (l < nums.length) {

            if (sum < s) {
                if (r == nums.length - 1) {
                    break;
                }
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }


            if (sum >= s)
                res = Math.min(res, r - l + 1);
        }

        return res == nums.length + 1 ? 0 : res;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(this.minSubArrayLen(10, arr));
    }
}
