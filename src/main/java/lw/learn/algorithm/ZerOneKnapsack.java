package lw.learn.algorithm;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-22 00:08:33
 **/
public class ZerOneKnapsack {

    public int zerOneKnapsack(int[] weight, int[] value, int capacity) {

        if (weight == null || value == null || weight.length != value.length || weight.length == 0) {
            return 0;
        }

        return zerOneKnapsack(weight, value, 0, 0, capacity);
    }



    private int zerOneKnapsack(int[] weight, int[] value, int index, int sum, int capacity) {

        if (index == weight.length || capacity < weight[index]) {
            return sum;
        }

        return Math.max(zerOneKnapsack(weight, value, index + 1, sum + value[index], capacity - weight[index]), zerOneKnapsack(weight, value, index + 1, sum, capacity));
    }

    @Test
    public void test() {
        int[] weight = {2, 2, 6, 5, 4};
        int[] value = {6, 3, 5, 4, 6};
        int capacity = 10;
        //System.out.println(zerOneKnapsack(weight, value, 10));
        System.out.println(zerOneKnapsack(weight, value, 0, capacity));
    }

    private int zerOneKnapsack(int[] weight, int[] value, int index, int capacity) {
        if (index == weight.length || capacity <= 0) {
            return 0;
        }
        int res = zerOneKnapsack(weight, value, index + 1, capacity);
        if (weight[index] <= capacity)
            res = Math.max(res, value[index] + zerOneKnapsack(weight, value, index + 1, capacity - weight[index]));
        return res;
    }

    @Test
    public void test1() {
        int[] weight = {2, 2, 6, 5, 4};
        int[] value = {6, 3, 5, 4, 6};
        int capacity = 10;
        int[][] memo = new int[weight.length][capacity];

        for (int i = 0; i < weight.length; i++) {
            //memo[]
        }
    }
}
