package lw.learn.lc.easy;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-27 00:56:28
 **/
public class P448_FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbersSpace(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[nums[i] - 1] = 1;
        }
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int i = 0;

        while (i < nums.length) {
            int index = nums[i] - 1;
            if (index != i) {
                if (nums[index] == nums[i]) {
                    nums[i] = 0;
                    i++;
                } else {
                    swap(nums, index, i);
                    if (nums[i] == 0) {
                        i++;
                    }
                }
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                res.add(j + 1);
            }
        }
        return res;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    

    @Test
    public void test() {
        int[] ints = JSON2Java.json2intArray("[4,3,2,7,8,2,3,1]");
        System.out.println(this.findDisappearedNumbersSpace(ints));
    }
}
