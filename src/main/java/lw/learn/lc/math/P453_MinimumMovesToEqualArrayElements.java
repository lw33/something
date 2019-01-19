package lw.learn.lc.math;

/**
 * @Author lw
 * @Date 2019-01-19 22:23:31
 **/
public class P453_MinimumMovesToEqualArrayElements {

    /**
     * 每次移动让剩余的 n-1 个数加 1，相当于每次移动让选定的那个数减 1，
     * 所以最少移动次数其实就是所有元素减去最小元素的和
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            min = min > nums[i] ? nums[i] : min;
            sum += nums[i];
        }
        return sum - min * nums.length;
    }
}
