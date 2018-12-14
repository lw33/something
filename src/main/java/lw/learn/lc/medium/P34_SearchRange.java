package lw.learn.lc.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-12-14 01:53:37
 **/
public class P34_SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if (i < 0) {
            return new int[]{-1, -1};
        }
        int start = i;
        int end = i;
        while (start >= 0 && nums[start] == nums[i]) {
            start--;
        }
        while (end < nums.length && nums[end] == nums[i]) {
            end++;
        }
        return new int[]{start + 1, end - 1};
    }

    @Test
    public void test() {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(this.searchRange(arr, 7)));
    }
}
