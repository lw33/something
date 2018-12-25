package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-24 01:24:29
 **/
public class P693_BinaryNumberWithAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        int pre = n & 1;
        for (int i = 1; i < 32; i++) {
            n >>>= 1;
            if ((n & 1) == pre) {
                return false;
            }
            pre = n & 1;
            if (n == 0) {
                break;
            }
        }
        return true;
    }
}
