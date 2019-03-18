package lw.learn.lc.array;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-03-18 21:31:51
 **/
public class P1013_PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {60, 60, 60};
        System.out.println(this.numPairsDivisibleBy60(arr));
    }
}
