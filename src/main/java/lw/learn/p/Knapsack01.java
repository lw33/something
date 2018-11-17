package lw.learn.p;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-16 22:56:10
 **/
public class Knapsack01 {

    private int[][] memoII;

    /**
     * @param w 物体的重量
     * @param v 物体的价值
     * @param c 背包的总容量
     * @return 所能装载的最大价值
     */
    public int knapsack01I(int[] w, int[] v, int c) {


        //return knapsack01I(w, v, 0, c);
        return knapsack01I(w, v, w.length - 1, c);
    }

    // [index .. n)
    // [0 .. index]
    private int knapsack01I(int[] w, int[] v, int index, int c) {

        if (index < 0 || c <= 0)
            return 0;

        int val = knapsack01I(w, v, index - 1, c);
        if (w[index] <= c)
            val = Math.max(val, (v[index] + knapsack01I(w, v, index - 1, c - w[index])));
        return val;
    }

    public int knapsack01II(int[] w, int[] v, int c) {

        memoII = new int[w.length][c + 1];

        return knapsack01II(w, v, 0, c);
    }

    // [index..n)
    private int knapsack01II(int[] w, int[] v, int index, int c) {
        if (index >= w.length || c <= 0)
            return 0;

        if (memoII[index][c] != 0)
            return memoII[index][c];

        int val = knapsack01I(w, v, index + 1, c);
        if (w[index] <= c)
            val = Math.max(val, (v[index] + knapsack01I(w, v, index + 1, c - w[index])));
        memoII[index][c] = val;
        return val;
    }

    public int knapsack01III(int[] w, int[] v, int c) {
        int[][] memo = new int[w.length][c + 1];

        for (int i = 0; i < c + 1; i++)
            memo[0][i] = w[0] <= i ? v[0] : 0;

        for (int i = 1; i < w.length; i++) {
            for (int j = 0; j < c + 1; j++) {
                memo[i][j] = memo[i - 1][j];
                if (w[i] <= j)
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
            }

        }

        return memo[w.length - 1][c];
    }

    public int knapsack01IV(int[] w, int[] v, int c) {

        int[][] memo = new int[2][c + 1];

        for (int i = 0; i < c + 1; i++)
            memo[0][i] = w[0] <= i ? v[0] : 0;

        for (int i = 1; i < w.length; i++) {
            for (int j = 0; j < c + 1; j++) {
                memo[i & 1][j] = memo[(i - 1) & 1][j];
                if (w[i] <= j)
                    memo[i & 1][j] = Math.max(memo[i & 1][j], v[i] + memo[(i - 1) & 1][j - w[i]]);
            }
        }

        return memo[(w.length - 1) & 1][c];
    }

    public int knapsack01V(int[] w, int[] v, int c) {

        int[] memo = new int[c + 1];

        for (int i = 0; i < c + 1; i++)
            memo[i] = w[0] <= i ? v[0] : 0;

        for (int i = 1; i < w.length; i++)
            for (int j = c; j >= w[i]; j--)
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);

        return memo[c];
    }

    @Test
    public void test1() {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        System.out.println(this.knapsack01I(w, v, 5));
        System.out.println(this.knapsack01II(w, v, 5));
        System.out.println(this.knapsack01III(w, v, 5));
        System.out.println(this.knapsack01IV(w, v, 5));
        System.out.println(this.knapsack01V(w, v, 5));
    }
}
