package lw.learn.lc.array;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-11 21:57:37
 **/
public class P985_SumOfEvenNumbersAfterQueries {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {

        int evenSum = 0;
        for (int i : A) {
            if (i % 2 == 0) {
                evenSum += i;
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][1];
            int val = queries[i][0];
            int old = A[index];
            A[index] += val;
            if (old % 2 == 0) {
                if (A[index] % 2 == 0) {
                    evenSum += val;
                } else {
                    evenSum -= old;
                }
            } else {
                if (A[index] % 2 == 0) {
                    evenSum += A[index];
                }
            }

            res[i] = evenSum;
        }
        return res;
    }

    @Test
    public void test() {

    }
}
