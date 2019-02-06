package lw.learn.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-03 20:13:23
 **/
public class P417_PacificAtlanticWaterFlow {

    /**
     * 使用两个数组记录 从边界开始访问整个数组
     * 如果两个数组都能到达 则可流向两个边界
     *
     * @param matrix
     * @return
     */
    public List<int[]> pacificAtlantic(int[][] matrix) {

        List<int[]> res = new ArrayList<>();

        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }


        int row = matrix.length;
        int col = matrix[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            dfs(matrix, i, 0, pacific, matrix[i][0]);
            dfs(matrix, i, col - 1, atlantic, matrix[i][col - 1]);
        }

        for (int i = 0; i < col; i++) {
            dfs(matrix, 0, i, pacific, matrix[0][i]);
            dfs(matrix, row - 1, i, atlantic, matrix[row - 1][i]);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, int i, int j, boolean[][] visited, int pre) {

        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || pre > matrix[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(matrix, i - 1, j, visited, matrix[i][j]);
        dfs(matrix, i, j + 1, visited, matrix[i][j]);
        dfs(matrix, i + 1, j, visited, matrix[i][j]);
        dfs(matrix, i, j - 1, visited, matrix[i][j]);
    }
}
