package lw.learn.lc.dp;

import lw.learn.utils.LCUtils;
import org.junit.Test;

import java.util.HashMap;

/**
 * @Author lw
 * @Date 2019-02-08 21:32:01
 **/
public class P494_TargetSum {

    HashMap<String, Integer> map = new HashMap<>();

    public int findTargetSumWays(int[] nums, int S) {

        return findTargetSumWays(nums, 0, S);

    }

    private int findTargetSumWays(int[] nums, int index, int s) {

        if (index == nums.length) {
            return s == 0 ? 1 : 0;
        }
        String key = index + "_" + s;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int res = findTargetSumWays(nums, index + 1, s - nums[index]) +
                findTargetSumWays(nums, index + 1, s + nums[index]);
        map.put(key, res);
        return res;
    }

    @Test
    public void test() {

        int[] arr = LCUtils.stringToIntegerArray("[1, 1, 1, 1, 1]");
        int s = 1;
        System.out.println(this.findTargetSumWays(arr, s));
    }
}
