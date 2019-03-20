package lw.learn.lc.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-10-21 23:22:46
 *
 * 128. 最长连续序列(Longest Consecutive Sequence)
 *
 * 题目难度： 困难
 *
 *
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 *     **输入:** [100, 4, 200, 1, 3, 2]
 *     **输出:** 4
 *     **解释:** 最长连续序列是 `[1, 2, 3, 4]。它的长度为 4。````
 *
 *
 *
 **/
public class P128_LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
                if (map.containsKey(num - 1)) {
                    max = Math.max(merge(map, num - 1, num), max);
                }
                if (map.containsKey(num + 1)) {
                    max = Math.max(merge(map, num, num + 1), max);
                }
            }
        }
        return max;
    }

    public int merge(Map<Integer, Integer> map, int less, int more) {
        int left = less - map.get(less) + 1;
        int rigth = more + map.get(more) - 1;
        int len = rigth - left + 1;
        map.put(left, len);
        map.put(rigth, len);
        return len;
    }
}
