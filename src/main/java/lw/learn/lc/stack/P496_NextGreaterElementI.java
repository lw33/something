package lw.learn.lc.stack;

import lw.learn.utils.LCUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author lw
 * @Date 2019-01-07 22:28:52
 **/
public class P496_NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        if (nums1.length == 0) {
            return res;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>(nums2.length);

        for (int i : nums2) {

            while (!stack.isEmpty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        //for (int i = 0; i < res.length; i++) {
        //    res[i] = map.get(nums1[i]);
        //}
        res = Arrays.stream(nums1).map(map::get).toArray();
        return res;
    }

    @Test
    public void test() {

        int[] nums1 = LCUtils.stringToIntegerArray("[4,1,2]");
        int[] nums2 = LCUtils.stringToIntegerArray("[1,3,4,2]");
        int[] ints = this.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }
}
