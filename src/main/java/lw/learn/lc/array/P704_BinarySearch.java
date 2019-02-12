package lw.learn.lc.array;

/**
 * @Author lw
 * @Date 2019-02-12 12:18:37
 **/
public class P704_BinarySearch {

    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length;
        while (end > start) {

            int mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
