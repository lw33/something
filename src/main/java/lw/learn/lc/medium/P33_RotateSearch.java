package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-12-14 00:08:00
 **/
public class P33_RotateSearch {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int k = start + ((end - start) >> 1);
            if (target == nums[k]) {
                return k;
            }
            if (nums[k] >= nums[start]) {
                if (target >= nums[start] && target < nums[k]) {
                    end = k - 1;
                } else {
                    start = k + 1;
                }
            } else {
                if (target >= nums[start] || target < nums[k]) {
                    end = k - 1;
                } else {
                    start = k + 1;
                }
            }
        }
        return -1;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        int mid = start + ((end - start) >> 1);
        while (end >= start) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + ((end - start) >> 1);
        }
        return -1;
    }
}
