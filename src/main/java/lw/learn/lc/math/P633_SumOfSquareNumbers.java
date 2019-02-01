package lw.learn.lc.math;

/**
 * @Author lw
 * @Date 2019-02-01 17:21:42
 **/
public class P633_SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {

        int sqrt = (int) Math.sqrt(c);
        int num1 = 0;
        int num2 = sqrt;
        while (num1 <= num2) {
            int sum = num1 * num1 + num2 * num2;
            if (sum > c) {
                num2--;
            } else if (sum < c) {
                num1++;
            } else {
                return true;
            }
        }
        return false;
    }
}
