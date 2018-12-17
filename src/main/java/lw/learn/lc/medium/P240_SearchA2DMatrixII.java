package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-12-17 20:00:50
 **/
public class P240_SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;

            } else {
                x++;

            }
        }
        return false;
    }
}
