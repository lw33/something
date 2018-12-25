package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-11-30 21:43:33
 **/
public class P264_NthUglyNumber {

    //  1, 2, 3, 4, 5, 6, 8, 9, 10, 12
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        nums[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.min(nums[index2] * 2, Math.min(nums[index3] * 3, nums[index5] * 5));
            if (nums[i] == nums[index2] * 2) index2++;
            if (nums[i] == nums[index3] * 3) index3++;
            if (nums[i] == nums[index5] * 5) index5++;
        }
        return nums[n - 1];
    }

}
