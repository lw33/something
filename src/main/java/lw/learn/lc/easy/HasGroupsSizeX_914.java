package lw.learn.lc.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-11-27 23:15:59
 **/
// TODO: 2018/11/28 待优化
public class HasGroupsSizeX_914 {

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length == 0)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.merge(i, 1, (a, b) -> a + b);
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
            }
        }
        if (min == 1) {
            return false;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int gcd = gcd(entry.getValue(), min);
            if (gcd == 0)
                return false;
        }
        return true;
    }

    int gcd(int a, int b) {

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 4, 3, 2, 1};
        this.hasGroupsSizeX(arr);
    }
}
