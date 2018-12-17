package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-12-17 15:23:16
 **/
public class P74_SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        int targetLevel = 0;
        for (; targetLevel < m; targetLevel++) {
            if (matrix[targetLevel][n - 1] >= target) {
                break;
            }
        }
        if (targetLevel == m) {
            return false;
        }

        int start = 0;
        int end = n;

        while (end > start) {
            int mid = start + ((end - start) >> 1);
            if (matrix[targetLevel][mid] == target) {
                return true;
            } else if (matrix[targetLevel][mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
