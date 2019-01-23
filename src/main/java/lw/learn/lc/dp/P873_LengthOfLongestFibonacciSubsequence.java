package lw.learn.lc.dp;

import java.util.HashSet;

/**
 * @Author lw
 * @Date 2019-01-22 22:03:23
 **/
public class P873_LengthOfLongestFibonacciSubsequence {

    public int lenLongestFibSubseq(int[] A) {

        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {

                int n1 = A[i];
                int n2 = A[j];
                int len = 2;
                int n3 = n1 + n2;
                while (set.contains(n3)) {
                    ++len;
                    max = max < len ? len : max;
                    n1 = n2;
                    n2 = n3;
                    n3 += n1;
                }
            }
        }
        return max >=3 ? max : 0;
    }


}
