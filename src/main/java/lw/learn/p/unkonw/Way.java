package lw.learn.p.unkonw;

/**
 * @Author lw
 * @Date 2018-11-27 21:19:44
 **/
public class Way {

    /**
     * @param n 一共有 1~n 的位置
     * @param m 来到的位置
     * @param p 可以走的步数
     * @param k 最终停留的位置
     * @return 一共有多少种走法
     */
    public int way(int n, int m, int p, int k) {

        if (p == 0) {
            return m == k ? 1 : 0;
        }
        int res;
        if (m == 1) {
            res = way(n, m + 1, p - 1, k);
        } else if (m == n) {
            res = way(n, m - 1, p - 1, k);
        } else {
            res = way(n, m + 1, p - 1, k) + way(n, m - 1, p - 1, k);
        }
        return res;
    }
}
