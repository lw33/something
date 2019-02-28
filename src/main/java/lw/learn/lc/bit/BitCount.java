package lw.learn.lc.bit;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-14 17:57:04
 **/
public class BitCount {

    public static int swar(int num) {
        num = (num & 0x55555555) + ((num >> 1) & 0x55555555);
        num = (num & 0x33333333) + ((num >> 2) & 0x33333333);
        num = (num & 0x0f0f0f0f) + ((num >> 4) & 0x0f0f0f0f);
        num = (num * 0x01010101) >> 24;
        return num;
    }

    @Test
    public void test() {
        System.out.println(swar(127));
    }


}
