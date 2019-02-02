package lw.learn.lc.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-02-02 20:38:02
 **/
public class P581_ShortestUnsortedContinuousSubarray {

    /**
     * 克隆出一个数组排序
     * 再与原数组比较
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {

        int l = 0;
        int r = nums.length - 1;
        int[] clone = nums.clone();
        Arrays.sort(clone);
        while (l < r) {
            if (nums[l] == clone[l]) l++;
            else break;
        }
        if (l == r) {
            return 0;
        }
        while (r > l) {
            if (nums[r] == clone[r]) r--;
            else break;
        }
        return r - l + 1;
    }

    @Test
    public void test() {
        int[] arr = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(this.findUnsortedSubarray(arr));
    }
}
