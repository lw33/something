package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-24 21:14:06
 **/
public class P476_NumberComplement {

    public int findComplement(int num) {

        int res = 0;
        for (int i = 0; i < 32; i++) {
            int j = num & 1;
            j = j == 1 ? 0 : 1;
            res |= j << i;
            num >>>= 1;
            if (num == 0) {
                break;
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(this.findComplement(2));
    }
}
