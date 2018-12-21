package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-18 13:17:20
 **/
public class P190_ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int result = 0;
        for(int i=0; i<32; i++){
            result |= n & 1;
            n >>>= 1; // 无符号左移，无论正负，都在高位插 0
            if(i < 31) // 最后一位不移
                result <<= 1;
        }
        return result;
    }
    
    @Test
    public void test() {
        System.out.println(this.reverseBits(43261596));

        System.out.println(Long.toBinaryString(4294967293l));
    }
}
