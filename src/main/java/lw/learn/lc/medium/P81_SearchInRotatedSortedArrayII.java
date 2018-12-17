package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-12-17 11:50:05
 **/
public class P81_SearchInRotatedSortedArrayII {

    public boolean searchBS(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0;
        int end = nums.length - 1;

        while (end >= start) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            while (start != mid && nums[start] == nums[mid]) {
                    start++;
            }
            if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= nums[start] || target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return false;
    }
    public boolean search(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
