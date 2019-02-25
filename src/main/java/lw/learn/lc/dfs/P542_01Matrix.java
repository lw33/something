package lw.learn.lc.dfs;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-02-24 09:48:36
 **/
public class P542_01Matrix {

    int m, n;
    public static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        m = matrix.length;
        n = matrix[0].length;
        int val = m + n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1
                        && !((i > 0 && matrix[i - 1][j] == 0)
                        || (i < m - 1 && matrix[i + 1][j] == 0)
                        || (j > 0 && matrix[i][j - 1] == 0)
                        || (j < n - 1 && matrix[i][j + 1] == 0))) {
                    matrix[i][j] = val;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dfs(matrix, i, j);
                }
            }
        }

        return matrix;
    }

    private void dfs(int[][] matrix, int i, int j) {
        for (int[] xy : d) {
            int x = i + xy[0];
            int y = j + xy[1];
            if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j] + 1) {
                matrix[x][y] = matrix[i][j] + 1;
                dfs(matrix, x, y);
            }
        }
    }

    @Test
    public void test() {
        int[][] arr = JSON2Java.json2int2Array("[[0,0,0],[0,1,0],[1,1,1]]");
        System.out.println(Arrays.deepToString(this.updateMatrix(arr)));
    }
}
