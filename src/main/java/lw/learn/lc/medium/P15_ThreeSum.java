package lw.learn.lc.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-10-18 21:18:56
 *
 * 15. 三数之和(3Sum)
 *
 * 题目难度： 中等
 *
 *
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *     例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 *     满足要求的三元组集合为：
 *     [
 *       [-1, 0, 1],
 *       [-1, -1, 2]
 *     ]
 **/
public class P15_ThreeSum {
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
