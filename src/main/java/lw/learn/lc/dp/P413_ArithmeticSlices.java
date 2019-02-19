package lw.learn.lc.dp;

/**
 * @Author lw
 * @Date 2019-02-18 22:52:59
 **/
public class P413_ArithmeticSlices {


    /**
     * 寻找以 i 结尾的等差数列
     *
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int res = 0;
        int dp = 0;
        int sub = A[1] - A[0];
        for (int i = 2; i < A.length; i++) {
            int subTmp = A[i] - A[i - 1];
            if (subTmp == sub) {
                res += ++dp;
            } else {
                sub = subTmp;
                dp = 0;
            }
        }
        return res;
    }
}
