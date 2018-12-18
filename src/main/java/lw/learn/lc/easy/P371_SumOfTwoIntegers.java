package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-18 00:25:26
 **/
public class P371_SumOfTwoIntegers {

    public int getSum(int a, int b) {
        while (b != 0) {
            int res = a ^ b;
            int carry = a & b;
            a = res;
            b = carry << 1;
        }
        return a;
    }
}
