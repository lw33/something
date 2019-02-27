package lw.learn.lc.dp;

import lw.learn.utils.LCUtils;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-27 21:12:54
 **/
public class P45_JumpGameII {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 跳的总步数
        int jump = 0;
        // 跳 jump 能到的最远位置
        int cur = 0;
        // 再跳一步能跳到的最远位置
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > cur) {
                jump++;
                cur = next;

                if (cur >= nums.length - 1) {
                    return jump;
                }
            }
            next = Math.max(next, i + nums[i]);
        }
        return jump;
    }

    @Test
    public void test() {
        int[] arr = LCUtils.stringToIntegerArray("[2,3,1,1,4]");
        System.out.println(this.jump(arr));
    }
}
