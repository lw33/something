package lw.learn.lc.fastest.easy;

/**
 * @Author lw
 * @Date 2018-12-07 13:28:32
 **/
// TODO 2018/12/7
public class RemoveDuplicates_80 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i++] = num;
            }
        }
        return i;
    }
}
