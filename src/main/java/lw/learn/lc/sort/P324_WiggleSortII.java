package lw.learn.lc.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-03-13 12:04:52
 **/
public class P324_WiggleSortII {

    // 先对数组排序，分为大数部分和小数部分，再穿插排序。
    // 注意顺序，例如[1，2，4，4，4，6]这个数组，通过降序穿插得到[4,6,2,4,1,4]。
    // 如果顺序排列，则会得到[1,4,2,4,4,6]不满足要求。
    // 这里是因为我们想尽量将小数部分的最大数放在边上，这样只用靠近一个大数部分的最大数。
    public void wiggleSort(int[] nums) {

        Arrays.sort(nums);
        int half = nums.length / 2;
        int j = nums.length - 1;
        if (nums.length % 2 == 0) {
            half--;
        }
        int i = half;

        int[] newArr = new int[nums.length];
        int ni = 0;

        while (i >= 0 && j > half) {
            newArr[ni++] = nums[i--];
            newArr[ni++] = nums[j--];
        }

        if (nums.length % 2 == 1) {
            newArr[ni] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, nums.length);
    }

    @Test
    public void test() {
        int[] arr = {5, 8, 3, 7, 2, 6, 1, 5, 5};
        this.wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
