package lw.learn.lc.array;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-12 17:12:25
 **/
public class P724_FindPivotIndex {

    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int lSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lSum == sum - lSum - nums[i]) {
                return i;
            }
            lSum += nums[i];
        }
        return -1;
    }

    @Test
    public void test() {
        int[] arr = {-1, -1, -1, 0, 1, 1};
        System.out.println(this.pivotIndex(arr));
    }
}
