package lw.learn.lc.math;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-01 20:48:44
 **/
public class P507_PerfectNumber {

    public boolean checkPerfectNumber(int num) {

        //int sqrt = (int) Math.sqrt(num);
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }
    
    @Test
    public void test() {
        System.out.println(this.checkPerfectNumber(28));
    }
}
