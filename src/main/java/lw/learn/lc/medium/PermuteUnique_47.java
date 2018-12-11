package lw.learn.lc.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-10 14:27:48
 **/
public class PermuteUnique_47 {

    HashSet<String> set;
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>(nums.length*2 );
        boolean[] used = new boolean[nums.length];
        List<Integer> p = new ArrayList<>(nums.length * 2);
        set = new HashSet<>(nums.length * 2);
        permutation(nums, "", 0, p, used, res);
        return res;

    }
    // p 中存在index个元素
    private void permutation(int[] nums,String str, int index, List<Integer> p, boolean[] used, List<List<Integer>> res) {
        if (index == nums.length) {
            if (set.contains(str)) {
                return;
            } else {
                set.add(str);
            }
            res.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                p.add(nums[i]);
                permutation(nums, str + nums[i],index + 1, p, used, res);
                used[i] = false;
                p.remove(p.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] arr = {1, 1, 2};
        System.out.println(this.permuteUnique(arr));
    }
}
