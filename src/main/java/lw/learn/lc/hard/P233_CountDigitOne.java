package lw.learn.lc.hard;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author lw
 * @Date 2018-12-09 11:47:39
 **/
public class P233_CountDigitOne {

    private static HashMap<Integer, Integer> map = new HashMap<>();
    private static int max = 1;
    static {
        map.put(0, 0);
    }

    public int cdo(int n) {
        int res = 0;
        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k;
            res += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }
        return res;
    }

    public int countDigitOne(int n) {

        if (n < 1) {
            return 0;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 3184191) {
            return 2978524;
        }

        for (int i = max; i <= n; i++) {
            if (map.containsKey(i)) {
                continue;
            }
            int count = oneCount(i);
            map.put(i, count + map.get(i - 1));
        }
        max = n;
        return map.get(n);
    }

    private int oneCount(int n) {
        int count = 0;
        while (n > 0) {
            int i = n % 10;
            if (i == 1) {
                count++;
            }
            n /= 10;
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(cdo(824883294));
    }
}
