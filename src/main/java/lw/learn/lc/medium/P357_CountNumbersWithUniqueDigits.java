package lw.learn.lc.medium;

import org.junit.Test;


/**
 * @Author lw
 * @Date 2018-12-18 22:57:29
 **/
public class P357_CountNumbersWithUniqueDigits {

    int count = 0;
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return count;
        }
        boolean[] used = new boolean[10];
        countNumbersWithUniqueDigits(n, 0, used);
        return count;
    }

    // 0 ... index
    private void countNumbersWithUniqueDigits(int n, int index, boolean[] used) {

        if (index <= n) {
            count++;
        }
        if (index == n) {
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (i == 0 && index == 0) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                countNumbersWithUniqueDigits(n, index + 1, used);
                used[i] = false;
            }
        }
    }


    @Test
    public void test() {
        System.out.println(this.countNumbersWithUniqueDigits(3));
    }
}
