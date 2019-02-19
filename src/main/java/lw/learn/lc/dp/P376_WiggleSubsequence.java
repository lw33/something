package lw.learn.lc.dp;

import lw.learn.utils.LCUtils;
import org.junit.Test;

import java.util.HashMap;

/**
 * @Author lw
 * @Date 2019-02-18 22:53:44
 **/
public class P376_WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {

        if (nums.length == 0) return 0;
        return Math.max(wiggleMaxLength(nums, 0, true), wiggleMaxLength(nums, 0, false));
    }

    HashMap<String, Integer> memo = new HashMap<>();

    private int wiggleMaxLength(int[] nums, int index, boolean up) {
        String key = index + "" + up;
        int res = 1;
        int max = 1;
        Integer integer = memo.get(key);
        if (integer != null) {
            return integer;
        }
        for (int i = index + 1; i < nums.length; i++) {
            if (up && nums[i] > nums[index]) {
                res += wiggleMaxLength(nums, i, false);
            } else if (!up && nums[i] < nums[index]) {
                res += wiggleMaxLength(nums, i, true);
            }
            max = Math.max(res, max);
            res = 1;
        }
        memo.put(key, max);
        return max;
    }

    @Test
    public void test() {
        int[] arr = LCUtils.stringToIntegerArray("[1,17,5,10,13,15,10,5,16,8]");
        System.out.println(this.wiggleMaxLength(arr));
    }
}
