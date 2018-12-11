package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-11-06 15:09:01
 **/
public class P303_2_NumArray_303 {


    private int[] sum;


    public P303_2_NumArray_303(int[] nums) {

        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }


}
