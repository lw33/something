package lw.learn.lc.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-12-23 20:45:08
 **/
public class P475_Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int res = 0;
       /* int res = 0;
        for (int house : houses) {
            res = Math.max(binarySearch(heaters, house), res);
        }*/
        return res;
    }

    private int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int min = Integer.MAX_VALUE;
        while (end > start) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                return 0;
            } else if (nums[mid] > target) {
                end = mid;
                min = Math.min(min, nums[mid] - target);
            } else {
                start = mid + 1;
                min = Math.min(min, target - nums[mid]);
            }
        }
        return min;
    }

    private int find(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(Math.abs(target - num), min);
        }
        return min;
    }


    @Test
    public void test() {
        //[282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923]
        //[823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612]
        int[] arr1 = {823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612};
        int[] arr2 = {282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923};
        for (int i : arr2) {
            System.out.println(find(arr1, i) + "===" + binarySearch(arr1, i));

        }
    }
}
