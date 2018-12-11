package lw.learn.lc.easy;

import org.junit.Test;

import java.util.HashSet;

/**
 * @Author lw
 * @Date 2018-12-09 00:58:25
 **/
public class P204_CountPrimes {
    private static HashSet<Integer> set = new HashSet<>();

    // 。。。测试用例。。。
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (set.contains(i)) {
                count++;
            } else if (isPrime(i)) {
                set.add(i);
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int num) {

        if (num < 4) {
            return true;
        }
        double sqrt = Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(isPrime(41));
        System.out.println(this.countPrimes(1500000));
    }
}
