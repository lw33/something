package lw.learn.lc.medium;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-06 22:51:02
 **/
public class RemoveDuplicates_80 {

    public int removeDuplicates(int[] nums) {
        int length = 0;
        int times = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                if (times <= 2) {
                    times++;
                }
            } else {
                length += times;
                times = 1;
            }
        }
        return length;
    }

    @Test
    public void test() {
        int[] arr = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(arr));
    }
}
