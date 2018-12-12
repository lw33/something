package lw.learn.lc.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-11 20:26:56
 **/
public class P40_CombinationSumII {

    HashSet<String> set;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        //set = new HashSet<>(2 * candidates.length);
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    public void combinationSum2(int[] candidates, int target, int index, List<Integer> ints, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(ints));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        ints.add(candidates[index]);
        combinationSum2(candidates, target - candidates[index], index + 1, ints, res);
        ints.remove(ints.size() - 1);
        combinationSum2(candidates,  target, index + 1,ints, res);
    }

    //candidates = [10,1,2,7,6,1,5], target = 8,
    @Test
    public void test() {
        int[] arr = {2,5,2,1,2};
        System.out.println(this.combinationSum2(arr, 5));
    }
}
