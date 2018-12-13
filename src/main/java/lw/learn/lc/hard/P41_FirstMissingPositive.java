package lw.learn.lc.hard;

import java.util.HashSet;

/**
 * @Author lw
 * @Date 2018-12-13 22:22:40
 **/
public class P41_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        int res = 1;
        while (set.contains(res))
            res++;
        return res;
    }
}
