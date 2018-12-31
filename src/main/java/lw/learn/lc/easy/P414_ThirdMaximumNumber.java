package lw.learn.lc.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-12-30 13:49:39
 **/
public class P414_ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        int[] nums3 = new int[3];
        nums3[2] = -1;
        int[] index = new int[1];
        Arrays.stream(nums).boxed()
                .distinct()
                .sorted((a, b) -> -a.compareTo(b))
                .limit(3).forEach(a -> nums3[index[0]++] = a);
        if (nums3[2] == -1) {
            return nums3[0];
        }
        return nums3[2];
    }

    @Test
    public void test() {
        int[] arr = { 2, 1};
        thirdMax(arr);
    }
}
