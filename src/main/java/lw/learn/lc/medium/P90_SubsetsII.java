package lw.learn.lc.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-18 00:32:57
 **/
// FIXME 2018/12/18  可以更快
public class P90_SubsetsII {

    HashSet<String> set;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        set = new HashSet<>();
        subsetsWithDup(nums, 0, list, res);
        return res;
    }

    private void subsetsWithDup(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> tmplist = new ArrayList<>(list);
            Collections.sort(tmplist);
            StringBuilder sb = new StringBuilder();
            for (Integer integer : tmplist) {
                sb.append(integer + "_");
            }
            if (set.contains(sb.toString())) {
                return;
            } else {
                set.add(sb.toString());
            }
            res.add(tmplist);
            return;
        }
        list.add(nums[index]);
        subsetsWithDup(nums, index + 1, list, res);
        list.remove(list.size() - 1);
        subsetsWithDup(nums, index + 1, list, res);
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 2};
        System.out.println(subsetsWithDup(arr));
    }
}
