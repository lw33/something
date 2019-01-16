package lw.learn.lc.greedy;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-14 20:05:13
 **/
public class P55_JumpGame {
    public boolean canJump(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i == nums.length - 1) {
                    return true;
                }
                boolean hasVal = false;
                for (int j = i - 1; j >= 0; --j) {
                    if (nums[j] > i - j) {
                        hasVal = true;
                        break;
                    }
                }
                if (!hasVal) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test() {
        int[] arr = JSON2Java.json2intArray("[2,5,0,0]");
        int[] arr1 = JSON2Java.json2intArray("[3,2,1,0,4]");
        System.out.println(this.canJump(arr));
        System.out.println(this.canJump(arr1));
    }
}
