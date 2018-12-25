package lw.learn.lc.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-12-24 20:24:26
 **/
public class P313_SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        Arrays.sort(primes);
        //List<Integer> indexs = new ArrayList<>(primes.length);
        int[] indexs = new int[primes.length];
        int[] res = new int[n];
        Arrays.fill(res, 1);

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * res[indexs[j]]);
            }
            res[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (min == primes[j] * res[indexs[j]]) {
                    indexs[j] = indexs[j] + 1;
                }
            }
        }
        return res[n - 1];
    }


    @Test
    public void test() {
        int i = 12;
        int[] primes = {2, 7, 13, 19};
        this.nthSuperUglyNumber(12, primes);

    }
}
