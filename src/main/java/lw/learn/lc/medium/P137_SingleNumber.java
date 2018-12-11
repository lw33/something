package lw.learn.lc.medium;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-24 20:12:24
 **/
public class P137_SingleNumber {

    public int singleNumber(int[] nums) {

        int l = 0;
        int h = nums.length - 1;

        while (h > l) {
            int[] patition = patition(nums, l, h);
            if (patition[1] - patition[0] - 1 == 1) {
                return nums[patition[0] + 1];
            } else {
                if ((patition[0] - l + 1) % 3 == 0) {
                    l = patition[1];
                } else {
                    h = patition[0];
                }
            }
        }
        return nums[h];
    }

    public int[] patition(int[] arr, int l, int h) {
        int less = l - 1;
        int more = h;
        while (l < more) {
            if (arr[l] < arr[h]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[h]) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        swap(arr, l, h);
        return new int[]{less, more + 1};
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void test() {
        int[] arr = {43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43};
        System.out.println(this.singleNumber(arr));
    }

}
