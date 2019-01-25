package lw.learn.lc.math;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-24 17:26:49
 **/
public class P365_WaterAndJugProblem {

    /**
     * z不能超过x+y且是x和y的最大公约数的倍数的时候才可以
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        if (z == x || z == y) {
            return true;
        }
        if (z % gcd(x, y) == 0) {
            return true;
        }
        return false;
    }

    public int gcd(int x, int y) {
        return (y > 0) ? gcd(y, x % y) : x;
    }

    @Test
    public void test() {
        System.out.println(this.gcd(2, 2));
        System.out.println(canMeasureWater(3, 5, 4));
        System.out.println(canMeasureWater(2, 6, 5));
    }
}
