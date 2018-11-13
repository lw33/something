package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-11-13 14:06:43
 **/
public class MoveZeroes_283 {

    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }

    }

    public void moveZeroes2(int[] nums) {

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
