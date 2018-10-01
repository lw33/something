package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-01 15:05:48
 **/
public class SearchInsert_35 {

    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int mid = start + ((end - start) >> 1);

        while (start <= end) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {

                end = mid - 1;
            }
            mid = start + ((end - start) >> 1);
        }

        return mid+1;
    }
    
    @Test
    public void test() {
        System.out.println(this.searchInsert(new int[]{1, 3, 5, 6}, 5));
    }
}
