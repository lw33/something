package lw.learn.lc.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @Author lw
 * @Date 2019-01-01 18:57:41
 **/
public class P398_RandomPickIndex {

    class Solution {

        private HashMap<Integer, List<Integer>> map;
        private Random r = new Random();

        public Solution(int[] nums) {
            map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
                list.add(i);
                map.putIfAbsent(nums[i], list);
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            return list.get(r.nextInt(list.size()));
        }
    }
}
