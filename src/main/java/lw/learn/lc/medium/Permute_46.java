package lw.learn.lc.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-15 10:33:00
 **/
public class Permute_46 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> p = new ArrayList<>();
        permutation(nums, 0, p, used, res);
        return res;
    }

    // p 中存在index个元素
    private void permutation(int[] nums, int index, List<Integer> p, boolean[] used, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                p.add(nums[i]);
                permutation(nums, index + 1, p, used, res);
                used[i] = false;
                p.remove(p.size() - 1);
            }
        }
    }
}
