package lw.learn.lc.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-11 19:44:52
 **/
public class P39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> ints = new ArrayList<>();
        combinationSum(candidates, 0, target, ints, res);
        return res;
    }

    public void combinationSum(int[] candidates, int index, int target, List<Integer> ints, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(ints));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        ints.add(candidates[index]);
        combinationSum(candidates, index, target - candidates[index], ints, res);
        ints.remove(ints.size() - 1);
        combinationSum(candidates, index + 1, target, ints, res);
    }

    /*
    candidates = [2,3,6,7], target = 7,
    [
      [7],
      [2,2,3]
    ]
     */
    @Test
    public void test() {
        int[] arr = {2, 3, 6, 7};
        System.out.println(this.combinationSum(arr, 7));
    }
}
