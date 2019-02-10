package lw.learn.lc.array;

import lw.learn.utils.LCUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2019-02-10 21:52:26
 **/
public class P697_DegreeOfAnArray {

    class Node {
        int times = 1;
        int start = -1;
        int end = -1;
    }

    public int findShortestSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int degree = 0;
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            Node node = map.getOrDefault(nums[i], new Node());
            node.times += 1;
            if (node.start == -1) {
                node.start = i;
            }
            node.end = i;
            degree = Math.max(node.times, degree);
            map.put(nums[i], node);
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            Node node = entry.getValue();
            if (node.times == degree) {
                min = Math.min(node.end - node.start + 1, min);
            }
        }
        return min;
    }

    @Test
    public void test() {
        int[] arr = LCUtils.stringToIntegerArray("[1, 2, 2, 3, 1]");
        System.out.println(this.findShortestSubArray(arr));
    }
}
