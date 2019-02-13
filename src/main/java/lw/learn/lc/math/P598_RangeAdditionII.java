package lw.learn.lc.math;

/**
 * @Author lw
 * @Date 2019-02-11 21:19:33
 **/
public class P598_RangeAdditionII {

    /**
     * 找出所有最小的操作范围 为重叠最多次
     *
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int maxCount(int m, int n, int[][] ops) {

        for (int[] op : ops) {
            if (op[0] < m) {
                m = op[0];
            }
            if (op[1] < n) {
                n = op[1];
            }
        }
        return m * n;
    }
}
