package lw.learn.lc.dp;

import lw.learn.utils.LCUtils;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-05 17:00:45
 **/
public class P718_MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] A, int[] B) {


        //return findLength(A, B, A.length - 1, B.length - 1);

        return 0;
    }

    /**
     * 不连续
     *
     * @param a
     * @param b
     * @param alen
     * @param blen
     * @return
     */
    private int findLength(int[] a, int[] b, int alen, int blen) {

        if (alen < 0 || blen < 0) {
            return 0;
        }
        int res;
        if (a[alen] == b[blen]) {
            res = 1 + findLength(a, b, alen - 1, blen - 1);
        } else {
            res = Math.max(findLength(a, b, alen - 1, blen),
                    findLength(a, b, alen, blen - 1));
        }
        return res;
    }

    @Test
    public void test() {
        int[] a = LCUtils.stringToIntegerArray("[0,1,1,1,1]");
        int[] b = LCUtils.stringToIntegerArray("[1,0,1,0,1]");
        System.out.println(this.findLength(a, b));
    }
}
