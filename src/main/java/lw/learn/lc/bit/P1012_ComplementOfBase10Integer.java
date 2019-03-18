package lw.learn.lc.bit;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-03-18 21:22:34
 **/
public class P1012_ComplementOfBase10Integer {

    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int res = 0;
        int i = 0;
        while (N > 0) {
            res |= ((N & 1) == 1 ? 0 : 1) << i;
            N >>= 1;
            i++;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(this.bitwiseComplement(0));
    }
}
