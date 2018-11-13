package lw.learn.lc.easy;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-11-13 15:31:11
 **/
public class TwoSum_1 {

    public int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {

            int find = target - numbers[i];
            if (map.containsKey(find)) {
                return new int[]{i, map.get(find)};
            } else {
                map.put(numbers[i], i);
            }

        }
        return null;
    }
}
