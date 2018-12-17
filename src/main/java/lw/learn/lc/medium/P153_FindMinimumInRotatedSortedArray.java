package lw.learn.lc.medium;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-17 14:12:16
 **/
public class P153_FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;

        while (end >= start) {
            int mid = start + ((end - start) >> 1);
            int left = mid - 1 < 0 ? 0 : mid - 1;
            int right = mid + 1 == nums.length ? mid : mid + 1;
            if (nums[mid] <= nums[left] && nums[mid] <= nums[right]) {
                return nums[mid];
            }
            if (nums[end] < nums[start] && nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }
    
    @Test
    public void test() {
        int[] arr = {1, 2, 3};
        System.out.println(this.findMin(arr));
    }
}
