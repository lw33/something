package lw.learn.lc.medium;

import java.util.*;

/**
 * @Author lw
 * @Date 2019-01-01 01:04:53
 **/
public class P229_MajorityElementII {

    public List<Integer> majorityElement666(int[] nums) {
        List<Integer> res = new ArrayList<>();

        return res;
    }

        public List<Integer> majorityElement(int[] nums) {
        int i = nums.length / 3;
        List<Integer> res = new ArrayList<>();
        /*Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(a -> a))
                .forEach((k, v) -> {
                    if (v.size() >= i) {
                        res.add(k);
                    }
                });*/

        Arrays.stream(nums).boxed()
                .collect(HashMap<Integer, Integer>::new,
                        (map, num) -> map.put(num, map.getOrDefault(num, 0) + 1),
                        Map::putAll
                ).forEach((k, v) -> {
            if (v > i) {
                res.add(k);
            }
        });

        return res;
    }


}
