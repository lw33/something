package lw.learn.lc.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-02-02 20:01:59
 **/
public class P867_TransposeMatrix {

    public int[][] transpose(int[][] A) {

        int[][] res = new int[A[0].length][A.length];

        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                res[i][j] = A[j][i];
            }
        }

        return res;
    }

    @Test
    public void test() {
        //[[1,2,3],[4,5,6]]
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] transpose = this.transpose(arr);
        System.out.println(Arrays.deepToString(transpose));
    }
}
