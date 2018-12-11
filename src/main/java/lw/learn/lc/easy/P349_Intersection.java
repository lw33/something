package lw.learn.lc.easy;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @Author lw
 * @Date 2018-11-05 17:32:12
 **/
public class P349_Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        TreeSet<Integer> list = new TreeSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            res[i++] = integer;
        }
        return res;
    }
}
