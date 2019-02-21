package lw.learn.lc.dp;

import lw.learn.utils.LCUtils;
import org.junit.Test;

import java.util.HashMap;

/**
 * @Author lw
 * @Date 2019-02-21 17:49:54
 **/
public class P403_FrogJump {

    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean canCross(int[] stones) {
        if (stones.length == 0) {
            return false;
        } else if (stones.length == 1) {
            return stones[0] == 0;
        } else if (stones.length == 2) {
            return stones[0] == 0 && stones[1] == 1;
        }
        return canCross(stones, 1, 1);
    }

    private boolean canCross(int[] stones, int index, int pre) {

        String key = index + "_" + pre;
        Boolean res = memo.get(key);
        if (res != null) {
            return res;
        }
        if (stones.length - 1 == index) {
            return true;
        } else if (stones.length <= index) {
            return false;
        }
        int i1 = stones[index] + pre;
        int i2 = stones[index] + pre + 1;
        int i3 = stones[index] + pre - 1;
        for (int i = index + 1; i < stones.length && stones[i] <= i2; i++) {
            if (stones[i] == i1) {
                if (canCross(stones, i, pre)) {
                    memo.put(key, true);
                    return true;
                }
            } else if (stones[i] == i2) {
                if (canCross(stones, i, pre + 1)) {
                    memo.put(key, true);
                    return true;
                }
            } else if (stones[i] == i3) {
                if (canCross(stones, i, pre - 1)) {
                    memo.put(key, true);
                    return true;
                }
            }
        }
        memo.put(key, false);
        return false;
    }

    @Test
    public void test() {
        int[] arr = LCUtils.stringToIntegerArray("[0,1,3,5,6,8,12,17]");
        System.out.println(this.canCross(arr));
    }
}
