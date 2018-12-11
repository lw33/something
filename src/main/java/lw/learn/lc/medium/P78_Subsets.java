package lw.learn.lc.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-07 23:11:09
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 **/
public class P78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        subsets(nums, 0, numList, res);
        return res;
    }

    private void subsets(int[] nums, int index, List<Integer> numList, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(numList));
            return;
        }
        numList.add(nums[index]);
        subsets(nums, index + 1, numList, res);
        numList.remove(numList.size() - 1);
        subsets(nums, index + 1, numList, res);
    }
    @Test
    public void test() {
        int[] arr = {1, 2, 3};
        System.out.println(this.subsets(arr));
    }
}
