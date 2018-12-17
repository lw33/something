package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-17 14:52:32
 **/
public class P463_IslandPerimeter {

    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < d.length; k++) {
                        int newX = i + d[k][0];
                        int newY = j + d[k][1];
                        if (notInArea(m, n, newX, newY) || grid[newX][newY] == 0) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public boolean notInArea(int m, int n, int x, int y) {
        return x < 0 || m <= x || y < 0 || n <= y;
    }
    
    @Test
    public void test() {
        int[][] arr = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        System.out.println(this.islandPerimeter(arr));
    }
}
