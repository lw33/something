package lw.learn.lc.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2019-03-08 13:48:52
 **/
public class P560_SubarraySumEqualsK {

    public int subarraySumI(int[] nums, int k) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraySum(int[] nums, int k) {

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            int sub = sum - k;
            if (map.containsKey(sub)) {
                res += map.get(sub);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
