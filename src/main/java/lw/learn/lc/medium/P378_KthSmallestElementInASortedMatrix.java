package lw.learn.lc.medium;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-12-18 13:18:02
 **/
// FIXME 2018/12/18  尽快实现
public class P378_KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m * n];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[cnt] = matrix[i][j];
                cnt++;
            }
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }
}
