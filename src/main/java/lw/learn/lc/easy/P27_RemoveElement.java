package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-10-01 14:54:26
 **/
public class P27_RemoveElement {

    public int removeElement(int[] nums, int val) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
