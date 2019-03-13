package lw.learn.lc.greedy;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-03-13 11:50:03
 **/
public class P1005_MaximizeSumOfArrayAfterKNegations {

    public int largestSumAfterKNegations(int[] A, int K) {

        Arrays.sort(A);
        int sum = 0;

        for (int i : A) {
            sum += i;
        }
        if (A[0] > 0) {
            return K % 2 == 0 ? sum : sum - A[0] - A[0];
        }
        for (int i = 0; i < A.length && K > 0; i++) {
            if (A[i] >= 0) {
                int sub = A[i];
                if (A[i] > A[i - 1]) {
                    sub = A[i - 1];
                }
                return K % 2 == 0 ? sum : sum - sub - sub;
            } else {
                A[i] = -A[i];
                sum += A[i] + A[i];
                K--;
            }
        }
        return sum;
    }
}
