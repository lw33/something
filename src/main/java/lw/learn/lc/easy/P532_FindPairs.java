package lw.learn.lc.easy;


import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-12-06 19:55:06
 **/
public class P532_FindPairs {

    public int findPairs(int[] nums, int k) {

        if (k < 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, 2);
            } else {
                map.put(num, 1);
            }
        }
        int sum = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            int num = iterator.next().getKey();
            int i1 = num + k;
            int i2 = num - k;
            if (map.containsKey(i1) || map.containsKey(i2)) {
                if (k == 0) {
                    if (map.get(num) == 2) {
                        map.put(num, 1);
                    } else {
                        iterator.remove();
                    }
                } else {
                    iterator.remove();
                }
                if (map.containsKey(i1)) {
                    if (k == 0) {
                        iterator.remove();
                    }
                    sum++;
                }
                if (map.containsKey(i2)) {
                    sum++;
                }
            }
        }
        return sum;
    }
    
    @Test
    public void test() {
        int[] arr = {1, 1, 1, 2, 1};
        int k = 1;
        System.out.println(this.findPairs(arr, k));
    }
}
