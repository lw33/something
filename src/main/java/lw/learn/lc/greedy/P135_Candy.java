package lw.learn.lc.greedy;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-02-22 12:39:55
 **/
public class P135_Candy {

    public int candy(int[] ratings) {

        int[] tmp = new int[ratings.length];
        Arrays.fill(tmp, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                tmp[i] = tmp[i - 1] + 1;
            }
        }

        int sum = tmp[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                tmp[i] = Math.max(tmp[i], tmp[i + 1] + 1);
            }
            sum += tmp[i];
        }
        //return Arrays.stream(tmp).sum();
        return sum;
    }
}
