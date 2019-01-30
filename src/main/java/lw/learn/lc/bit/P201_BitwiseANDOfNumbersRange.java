package lw.learn.lc.bit;

/**
 * @Author lw
 * @Date 2019-01-30 22:33:25
 **/
public class P201_BitwiseANDOfNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {

        int count = 0;
        while (m != n) {
            //右移1位后判断
            m >>= 1;
            n >>= 1;
            count++;
        }
        return n << count;
    }
}
