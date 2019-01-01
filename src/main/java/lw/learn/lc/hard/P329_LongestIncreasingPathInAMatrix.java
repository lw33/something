package lw.learn.lc.hard;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-01 17:10:26
 **/
public class P329_LongestIncreasingPathInAMatrix {

    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        if (n == 0)
            return 0;
        int[][] length = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (length[i][j] == 0) {
                    path(matrix, i, j, length);
                }
                max = max < length[i][j] ? length[i][j] : max;
            }
        }

        return max;
    }

    private int path(int[][] matrix, int row, int col, int[][] length) {
        int res = 0;
        int max = 1;
        for (int i = 0; i < d.length; i++) {
            int newX = row + d[i][0];
            int newY = col + d[i][1];
            if (inArea(newX, newY, matrix.length, matrix[0].length) &&
                    matrix[row][col] < matrix[newX][newY]) {
                if (length[newX][newY] == 0) {
                    length[newX][newY] = path(matrix, newX, newY, length);
                }
                max = Math.max(length[newX][newY] + 1, max);
            }
        }
        res += max;
        length[row][col] = res;
        return res;
    }

    private boolean inArea(int newX, int newY, int m, int n) {
        return newX >= 0 && newX < m && newY >= 0 && newY < n;
    }
    
    @Test
    public void test() {
        int[][] arr = JSON2Java.json2int2Array("[[9,9,4],[6,6,8],[2,1,1]]");
        System.out.println(this.longestIncreasingPath(arr));
    }

}
