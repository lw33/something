package lw.learn.p.z.dp;

/**
 * @Author lw
 * @Date 2019-02-26 12:56:14
 **/
public class WalkWays {

    public int walkWays(int n, int k, int m, int p) {
        return walk(n, k, m, p);
    }

    private int walk(int n, int k, int m, int p) {
        if (p == 0) {
            return m == k ? 1 : 0;
        }
        if (n - 1 == m) {
            return walk(n, m - 1, k, p - 1);
        } else if (0 == m) {
            return walk(n, m + 1, k, p - 1);
        } else {
            return walk(n, m - 1, k, p - 1) + walk(n, m + 1, k, p - 1);
        }
    }
}
