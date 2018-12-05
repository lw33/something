package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-05 23:26:32
 **/
public class IsMonotonic_896 {

    public boolean isMonotonic(int[] A) {
        int count = 1;
        int eq = 1;
        for (int i = 0; i < A.length - 1; i++) {
            int s = A[i + 1] - A[i];
            if (s > 0) {
                count++;
            } else if (s < 0) {
            } else {
                count++;
                eq++;
            }
        }
        return count == eq || count == A.length;
    }

    @Test
    public void test() {
        int[] arr = {6, 5, 4, 4};
        System.out.println(this.isMonotonic(arr));
    }
}
