package lw.learn.lc.map;

import java.util.HashMap;

/**
 * @Author lw
 * @Date 2019-03-08 13:16:04
 **/
public class P525_ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i] == 0 ? -1 : 1;
            sum += num;
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}
