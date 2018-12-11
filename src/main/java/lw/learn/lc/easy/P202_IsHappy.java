package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-09 00:07:43
 **/
public class P202_IsHappy {

    public boolean isHappy(int n) {

        int sum;
        while (true) {
            sum = 0;
            while (n > 0) {
                int i = n % 10;
                sum += i * i;
                n /= 10;
            }
            if (sum == 1) {
                return false;
            } else if (sum == 4) {
                return true;
            }
            n = sum;
        }
    }
    @Test
    public void test() {
        System.out.println(this.isHappy(19));
    }
}
