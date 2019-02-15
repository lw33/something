package lw.learn.lc.twopointers;

import lw.learn.utils.LCUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-02-15 10:10:15
 **/
public class P977_SquaresOfASortedArray {

    /**
     * 双指针 找左右两边较大的填到 当前最大索引的地方
     *
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        int l = 0;
        int r = A.length - 1;
        int[] res = new int[A.length];
        int index = r;
        while (r >= l) {
            int rP2 = A[r] * A[r];
            int lP2 = A[l] * A[l];
            if (rP2 >= lP2) {
                res[index--] = rP2;
                r--;
            } else {
                res[index--] = lP2;
                l++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = LCUtils.stringToIntegerArray("[-4,-1,0,3,10]");
        int[] ints = this.sortedSquares(arr);
        System.out.println(Arrays.toString(ints));

    }
}
