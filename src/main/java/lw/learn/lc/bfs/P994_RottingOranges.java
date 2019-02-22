package lw.learn.lc.bfs;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-21 22:21:34
 **/
public class P994_RottingOranges {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int good = 0;
        int bad = 0;
        int none = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    good++;
                } else if (grid[i][j] == 2) {
                    bad++;
                } else {
                    none++;
                }
                if (!visited[i][j] && grid[i][j] != 0) {
                    if (!dfs(grid, i, j, visited)) {
                        return -1;
                    }
                }
            }
        }
        if (good == 0 || (none + bad) == m * n) {
            return 0;
        }
        int minues = 0;
        while (good > 0) {
            minues++;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        if (i > 0 && grid[i - 1][j] == 1) {
                            good--;
                            grid[i - 1][j] = 666;
                        }
                        if (j > 0 && grid[i][j - 1] == 1) {
                            good--;
                            grid[i][j - 1] = 666;
                        }
                        if (i < m - 1 && grid[i + 1][j] == 1) {
                            good--;
                            grid[i + 1][j] = 666;
                        }
                        if (j < n - 1 && grid[i][j + 1] == 1) {
                            --good;
                            grid[i][j + 1] = 666;
                        }
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 666) {
                        grid[i][j] = 2;
                    }
                }
            }
        }
        return minues;
    }

    private boolean dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return false;
        }
        visited[i][j] = true;
        boolean res = grid[i][j] == 2;
        res = dfs(grid, i - 1, j, visited) || res;
        res = dfs(grid, i, j + 1, visited) || res;
        res = dfs(grid, i + 1, j, visited) || res;
        res = dfs(grid, i, j - 1, visited) || res;
        return res;
    }

    @Test
    public void test() {
        int[][] arr = JSON2Java.json2int2Array("[[1,1,2,0,2,0]]");
        System.out.println(this.orangesRotting(arr));
    }
}
