package lw.learn.lc.map;

import lw.learn.utils.LCUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2019-02-13 08:50:12
 **/
public class P594_LongestHarmoniousSubsequence {

    /**
     * map 中存当前数前面数的频率
     * 从开始位置开始找 然后从 map 中找到前面比他小一 大一 等于 的数
     * 然后运算比较
     * 最后将 该元素放入 map
     *
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int max = 0;
        for (int num : nums) {
            Integer ltOne = map.getOrDefault(num + 1, 0);
            Integer gtOne = map.getOrDefault(num - 1, 0);
            int eq = map.getOrDefault(num, 0) + 1;
            if (ltOne > 0 || gtOne > 0) {
                max = Math.max(max, eq + Math.max(ltOne, gtOne));
            }
            map.put(num, eq);
        }
        return max;
    }

    @Test
    public void test() {
        int[] arr = LCUtils.stringToIntegerArray("[1,1,1,1]");
        System.out.println(this.findLHS(arr));
    }
}
