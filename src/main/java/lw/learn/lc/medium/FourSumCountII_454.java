package lw.learn.lc.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-11-13 20:03:08
 **/
public class FourSumCountII_454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int tmp = A[i] + B[j];
                if (map.containsKey(tmp)) {
                    map.put(tmp, map.get(tmp) + 1);
                } else {
                    map.put(tmp, 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int tmp = C[i] + D[j];
                Integer integer = map.get(-tmp);
                if (integer != null) {
                    res += integer;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] A = {1, 1};
        int[] B = {-1, -1};
        int[] C = {-1, -1};
        int[] D = {1, 1};
        System.out.println(this.fourSumCount(A, B, C, D));
    }
}
