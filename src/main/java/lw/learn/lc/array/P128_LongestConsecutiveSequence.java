package lw.learn.lc.array;

import java.util.HashMap;

/**
 * @Author lw
 * @Date 2019-02-27 00:25:55
 **/
public class P128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
                if (map.containsKey(num - 1)) {
                    max = Math.max(max, merge(map, num - 1, num));
                }
                if (map.containsKey(num + 1)) {
                    max = Math.max(max, merge(map, num, num + 1));
                }
            }
        }
        return 0;
    }

    public int merge(HashMap<Integer, Integer> map, int less, int more) {
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }
}
