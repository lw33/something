package lw.learn.lc.easy;

import java.util.HashMap;

/**
 * @Author lw
 * @Date 2018-12-26 22:48:27
 **/
public class P961_NRepeatedElementInSize2NArray {

    public int repeatedNTimes(int[] A) {

        HashMap<Integer, Integer> hashMap = new HashMap<>(A.length);
        for (int i : A) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
            if (hashMap.get(i) > 1) {
                return i;
            }
        }
        return 0;
    }
}
