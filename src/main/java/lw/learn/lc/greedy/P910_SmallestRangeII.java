package lw.learn.lc.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-12 19:32:13
 **/

// FIXME 2019/1/12
public class P910_SmallestRangeII {

    public int smallestRangeII(int[] A, int K) {

        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {

        }
        return 0;
    }

    @Test
    public void test() {

        int[] arr = {1, 3, 6};
        System.out.println(this.smallestRangeII(arr, 3));
    }
}
