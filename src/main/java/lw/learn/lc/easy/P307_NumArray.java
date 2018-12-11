package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-11-06 15:09:01
 **/
public class P307_NumArray {


    private int[] sum;
    private int[] data;

    public P307_NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        data = new int[nums.length];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            data[i - 1] = nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public void update(int i, int val) {
        data[i] = val;
        for (int j = i + 1; j < sum.length; j++) {
            sum[j] = sum[j - 1] + data[j - 1];
        }
    }
}
