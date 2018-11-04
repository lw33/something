package lw.learn.algorithm;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-22 12:58:07
 **/
public class ZerOneKnapsack1 {

    //0 ... index 
    private int zk(int[] weight, int[] value, int index, int capacity) {
        if (index < 0 || capacity <= 0) {
            return 0;
        }
        int res = zk(weight, value, index - 1, capacity);
        if (weight[index] <= capacity) {
            res = Math.max(res, value[index] + zk(weight, value, index - 1, capacity - weight[index]));
        }
        return res;
    }

    @Test
    public void test() {
        int[] weight = {2, 2, 6, 5, 4};
        int[] value = {6, 3, 5, 4, 6};
        int capacity = 10;
        //int[][] memo = new int[weight.length][capacity];
        System.out.println(zk(weight, value, weight.length - 1, capacity));
    }

    @Test
    public void test1() {
        int[] weight = {2, 2, 6, 5, 4};
        int[] value = {6, 3, 5, 4, 6};
        int capacity = 10;
        int[][] memo = new int[weight.length][capacity];

        for (int i = 0; i < memo.length; i++) {

        }
    }

}
