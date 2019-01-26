package lw.learn.lc.array;

import lw.learn.utils.LCUtils;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-26 08:34:40
 **/
public class P849_MaximizeDistanceToClosestPerson {

    /**
     * 寻找中间 0 最多的
     * 但要注意两遍边界为 0 的情况
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {

        // 记录 最大
        int max = 0;
        // 记录 最长
        int len = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                ++len;
            } else {
                if (i == len) {
                    max = len;
                } else {
                    // 将最长转换成最大 注意 奇偶
                    len = (len & 1) == 1 ? len / 2 + 1 : len / 2;
                    max = max < len ? len : max;
                }
                len = 0;
            }
        }
        if (len > 0) {
            if (max < len) {
                max = len;
            }
        }
        return max;
    }
    
    @Test
    public void test() {
        int[] arr = LCUtils.stringToIntegerArray("[1,0,0,0,1,0,1]");
        System.out.println(this.maxDistToClosest(arr));
    }
}
