package lw.learn.lc.math;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-01 17:33:17
 **/
public class P868_BinaryGap {

    public int binaryGap(int N) {

        if ((N & (N - 1)) == 0) {
            return 0;
        }
        while ((N & 1) == 0) {
            N >>>= 1;
        }
        N >>>= 1;
        int len = 1;
        int max = 0;
        while (N > 0) {
            int i = N & 1;
            if (i == 1) {
                max = max < len ? len : max;
                len = 1;
            } else {
                len++;
            }
            N >>>= 1;
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(this.binaryGap(5));
    }
}
