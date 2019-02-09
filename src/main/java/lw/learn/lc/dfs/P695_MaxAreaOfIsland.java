package lw.learn.lc.dfs;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-09 08:48:07
 **/
public class P695_MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        int max = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j, visited));
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(grid, i - 1, j, visited) +
                dfs(grid, i, j + 1, visited) +
                dfs(grid, i + 1, j, visited) +
                dfs(grid, i, j - 1, visited);

    }

    @Test
    public void test() {
        int[][] arr = JSON2Java.json2int2Array("[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]");
        System.out.println(this.maxAreaOfIsland(arr));
    }
}
