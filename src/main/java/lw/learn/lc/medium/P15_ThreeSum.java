package lw.learn.lc.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-10-18 21:18:56
 * <p>
 * 15. 三数之和(3Sum)
 * <p>
 * 题目难度： 中等
 * <p>
 * <p>
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 **/
public class P15_ThreeSum {

    @Test
    public void test() {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(this.threeSum1(arr));
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int index = 0;
        while (index < nums.length - 2) {
            int start = index + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[index] + nums[start] + nums[end];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[index], nums[start], nums[end]));
                }
                if (sum >= 0) {
                    while (nums[end--] == nums[end] && start < end) ;
                }
                if (sum <= 0) {
                    while (nums[start] == nums[++start] && start < end) ;
                }
            }
            while (nums[index] == nums[++index] && index < nums.length - 2) ;
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        return null;
    }


}
