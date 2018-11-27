package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-11-27 16:38:34
 **/
public class FindMaximumXOR_421 {

    public int findMaximumXOR(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(nums[i] ^ nums[j], max);
            }
        }
        return max;
    }
}
