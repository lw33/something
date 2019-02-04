package lw.learn.lc.twopointers;

/**
 * @Author lw
 * @Date 2019-02-03 08:35:19
 **/
public class P283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
