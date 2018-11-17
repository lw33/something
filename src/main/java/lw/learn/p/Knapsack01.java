package lw.learn.p;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-16 22:56:10
 **/
public class Knapsack01 {

    /**
     * @param w 物体的重量
     * @param v 物体的价值
     * @param c 背包的总容量
     * @return 所能装载的最大价值
     */
    public int knapsack01I(int[] w, int[] v, int c) {
        return knapsack01I(w, v, 0, c);
    }

    // [index .. n)
    private int knapsack01I(int[] w, int[] v, int index, int c) {

        if (index >= w.length || c <= 0)
            return 0;
        int val = knapsack01I(w, v, index + 1, c);
        if (w[index] <= c)
            val = Math.max(val, (v[index] + knapsack01I(w, v, index + 1, c - w[index])));

        return val;
    }

    public int knapsack01II(int[] w, int[] v, int c) {

        return knapsack01II(w, v, w.length - 1, c);
    }

    private int knapsack01II(int[] w, int[] v, int index, int c) {

        return 0;
    }


    @Test
    public void test1() {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        System.out.println(this.knapsack01I(w, v, 5));
    }
}
