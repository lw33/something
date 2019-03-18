package lw.learn.lc.array;

import lw.learn.utils.LCUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-03-18 21:37:56
 **/
public class P1014_CapacityToShipPackagesWithinDDays {


    int[][] memo;
    int[] sums;

    public int shipWithinDays(int[] weights, int D) {
        memo = new int[weights.length][D + 1];
        for (int i = 0; i < weights.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        int sum = 0;
        sums = new int[weights.length];
        for (int i = weights.length - 1; i >= 0; i--) {
            sum += weights[i];
            sums[i] = sum;
        }
        return shipWithinDays(weights, 0, D);
    }

    private int shipWithinDays(int[] weights, int index, int d) {
        if (weights.length == index) {
            return 0;
        }
        if (memo[index][d] != -1) {
            return memo[index][d];
        }
        if (d == 1) {
            return sums[index];
        }
        int res = 0;
        int max;
        int min = Integer.MAX_VALUE;
        for (int i = index; i <= weights.length - d; i++) {
            res += weights[i];
            max = Math.max(shipWithinDays(weights, i + 1, d - 1), res);
            min = Math.min(max, min);
        }
        memo[index][d] = min;
        return min;
    }

    @Test
    public void test() {
        //int[] arr = {1, 2, 3, 4, 5};
        int[] arr = LCUtils.stringToIntegerArray("[3,2,2,4,1,4]");
        System.out.println(Arrays.stream(arr).skip(2).sum());
        //int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] weights = LCUtils.stringToIntegerArray("[3,2,2,4,1,4]");
        int D = 3;
        System.out.println(this.shipWithinDays(weights, D));

    }
}
