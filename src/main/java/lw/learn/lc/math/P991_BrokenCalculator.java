package lw.learn.lc.math;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-22 16:24:45
 **/
public class P991_BrokenCalculator {

    public int brokenCalc(int X, int Y) {
        if (X >= Y) {
            return X - Y;
        }

        if ((Y & 1) == 0) {
            return 1 + brokenCalc(X, Y / 2);
        } else {
            return 1 + brokenCalc(X, Y + 1);
        }
    }

    @Test
    public void test() {
        int x = 2;
        int y = 3;
        System.out.println(this.brokenCalc(x, y));
    }
}
