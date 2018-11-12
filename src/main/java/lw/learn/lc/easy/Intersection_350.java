package lw.learn.lc.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-05 17:32:12
 **/
public class Intersection_350 {

    public int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums1.length < nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        for (int i : nums1) {
            list1.add(i);
        }
        for (int i : nums2) {
            if (list1.contains(i)) {
                list.add(i);
                list1.remove(Integer.valueOf(i));
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
