package lw.learn.lc.array;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-12 00:47:25
 **/
public class P238_ProductOfArrayExceptSelf {

    public int[] productExceptSelf666666(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int accumulate = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] *= accumulate;
            accumulate *= nums[i];
        }
        return res;
    }

    public int[] productExceptSelf666(int[] nums) {

        if (nums.length < 2) {
            return nums;
        }

        boolean zero = false;
        int accumulate = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && !zero) {
                zero = true;
            } else {
                accumulate *= nums[i];
            }
        }
        int[] res = new int[nums.length];
        if (accumulate == 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            if (zero) {
                if (nums[i] == 0) {
                    res[i] = accumulate;
                    break;
                }
            } else {
                res[i] = accumulate / nums[i];
            }
        }
        return res;
    }
    public int[] productExceptSelf(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }


        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    res[j] *= nums[i];
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = JSON2Java.json2intArray("[1,2,3,4]");
        int[] arr1 = JSON2Java.json2intArray("[0,0]");
        //System.out.println(Arrays.toString(productExceptSelf(arr)));
        //System.out.println(Arrays.toString(productExceptSelf666(arr)));
        System.out.println(Arrays.toString(productExceptSelf666(arr1)));
        System.out.println(Arrays.toString(productExceptSelf666666(arr)));
        System.out.println(Arrays.toString(productExceptSelf666666(arr1)));
    }
}
