package lw.learn.lc.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-12-22 22:22:09
 **/
public class P628_MaximumProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int i2 = nums[nums.length - 1] * nums[nums.length - 2];
        if (nums[1] < 0) {
            int i1 = nums[0] * nums[1];
            return Math.max(i1 * nums[nums.length - 1], i2 * nums[nums.length - 3]);
        } else {
            return i2 * nums[nums.length - 3];
        }
    }

    @Test
    public void test() {
        int[] arr = {722, 634, -504, -379, 163, -613, -842, -578, 750, 951, -158, 30, -238, -392, -487, -797, -157, -374, 999, -5, -521, -879, -858, 382, 626, 803, -347, 903, -205, 57, -342, 186, -736, 17, 83, 726, -960, 343, -984, 937, -758, -122, 577, -595, -544, -559, 903, -183, 192, 825, 368, -674, 57, -959, 884, 29, -681, -339, 582, 969, -95, -455, -275, 205, -548, 79, 258, 35, 233, 203, 20, -936, 878, -868, -458, -882, 867, -664, -892, -687, 322, 844, -745, 447, -909, -586, 69, -88, 88, 445, -553, -666, 130, -640, -918, -7, -420, -368, 250, -786};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(this.maximumProduct(arr));
        System.out.println(984 * 960 * 999);
    }
}
