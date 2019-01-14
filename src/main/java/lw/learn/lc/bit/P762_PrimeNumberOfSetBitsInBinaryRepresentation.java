package lw.learn.lc.bit;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-14 13:39:57
 **/
public class P762_PrimeNumberOfSetBitsInBinaryRepresentation {

    public int countPrimeSetBits666(int L, int R) {
        boolean[] mark = new boolean[32 + 1];
        mark[2] = mark[3] = mark[5] = mark[7] = true;
        mark[11] = mark[13] = mark[17] = mark[19] = mark[23] = true;
        mark[29] = mark[31] =true;
        int res = 0;
        for (int i = L; i <= R; i++) {
            int c = Integer.bitCount(i);
            if (mark[c]) res++;
        }

        return res;
    }
    public int countPrimeSetBits(int L, int R) {

        if (R < L) {
            return 0;
        }
        int res = 0;
        for (int i = L; i <= R; i++) {
            int bitCount = 0;
            int tmp = i;
            while (tmp > 0) {
                bitCount += tmp & 1;
                tmp >>>= 1;
            }
            if (isPrime(bitCount)) {
                res++;
            }
        }
        return res;
    }

    public boolean isPrime(int num) {
        switch (num) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 11:
            case 13:
            case 17:
            case 19:
            case 23:
            case 29:
            case 31:
                return true;
            default:
                return false;
        }
    }

    @Test
    public void test() {
        int a = 842;
        int b = 888;
        System.out.println(this.countPrimeSetBits(a, b));
    }
}
