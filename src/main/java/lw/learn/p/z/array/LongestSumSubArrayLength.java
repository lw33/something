package lw.learn.p.z.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-11-25 15:26:15
 **/
// TODO: 2018/11/25 LongestSumSubArrayLength
public class LongestSumSubArrayLength {

    public int maxLength(int[] arr, int k) {
        if(arr == null || arr.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(len, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }

    @Test
    public void test() {
        Map<Integer, Integer> map = new HashMap<>();
        int i = map.get(1);
        System.out.println(i);
    }
}
