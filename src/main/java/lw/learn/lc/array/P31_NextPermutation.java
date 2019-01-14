package lw.learn.lc.array;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-14 13:04:01
 **/
public class P31_NextPermutation {

    public void nextPermutation(int[] nums) {

        if (nums.length < 2) {
            return;
        }

        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i-1]) {
                        int tmp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = tmp;
                        Arrays.sort(nums, i, nums.length);
                        return;
                    }
                }
            }
        }
        if (i == 0) {
            int start = 0;
            int end = nums.length - 1;
            while (end > start) {
                int tmp = nums[end];
                nums[end] = nums[start];
                nums[start] = tmp;
                end--;
                start++;
            }
        }
    }

    @Test
    public void test() {
        int[] arr = JSON2Java.json2intArray("[4,2,0,2,3,2,0]");
        int[] arr1 = JSON2Java.json2intArray("[1,3,2]");
        this.nextPermutation(arr);
        this.nextPermutation(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }
}
