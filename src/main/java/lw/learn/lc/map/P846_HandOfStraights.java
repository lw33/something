package lw.learn.lc.map;


import lw.learn.utils.LCUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author lw
 * @Date 2019-01-24 21:52:44
 **/
public class P846_HandOfStraights {

    public boolean isNStraightHand(int[] hand, int W) {

        if (hand.length % W != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if (map.size() < W) {
            return false;
        }
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> firstEntry = map.firstEntry();
            map.remove(firstEntry.getKey());
            int w = W - 1;
            ArrayList<Integer> list = new ArrayList<>(map.keySet());
            int pre = firstEntry.getKey();
            for (int i = 0; i < w; i++) {
                Integer key = list.get(i);
                if (pre + 1 != key) {
                    return false;
                }
                pre = key;
                Integer times = map.get(key);
                int minus = times - firstEntry.getValue();
                if (minus < 0) {
                    return false;
                } else if (minus == 0) {
                    map.remove(key);
                } else {
                    map.put(key, minus);
                }
            }
            if (map.size() < W && map.size() > 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        int[] ints = LCUtils.stringToIntegerArray("[1,2,3,6,2,3,4,7,8]");
        System.out.println(this.isNStraightHand(ints, 3));
    }
}
