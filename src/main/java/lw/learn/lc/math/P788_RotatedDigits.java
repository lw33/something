package lw.learn.lc.math;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-12 19:08:54
 **/
public class P788_RotatedDigits {

    static boolean[] good = new boolean[10];
    static boolean[] notNum = new boolean[10];

    static {
        good[2] = true;
        good[5] = true;
        good[6] = true;
        good[9] = true;
        notNum[4] = true;
        notNum[3] = true;
        notNum[7] = true;
    }

    /**
     * 将旋转后的数不为数的数存在 notNum 中 如果数中有 则不好
     * 并且将可能好的数存在 good 中 如果数中没有 notNum 中的数 并且存在好数 则好
     *
     * @param N
     * @return
     */
    public int rotatedDigits(int N) {
        if (N < 2) {
            return 0;
        }
        int count = 1;
        for (int i = 5; i <= N; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isGood(int num) {

        boolean hasGood = false;
        while (num > 0) {
            int i = num % 10;
            if (notNum[i]) {
                return false;
            }
            if (good[i]) {
                hasGood = true;
            }

            num /= 10;
        }
        return hasGood;
    }


    @Test
    public void test() {
        int n = 100;
        System.out.println(this.rotatedDigits(n));
    }
}
