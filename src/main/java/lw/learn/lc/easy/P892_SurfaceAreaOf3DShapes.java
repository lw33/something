package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-17 15:14:00
 **/
public class P892_SurfaceAreaOf3DShapes {

    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int surfaceArea(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }

        int area = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    for (int k = 0; k < d.length; k++) {
                        int newX = i + d[k][0];
                        int newY = j + d[k][1];
                        if (notInArea(m, n, newX, newY) || grid[newX][newY] == 0) {
                            area += grid[i][j];
                        } else {
                            if (grid[i][j] > grid[newX][newY]) {
                                area += grid[i][j] - grid[newX][newY];
                            }
                        }
                    }
                    area += 2;
                }
            }
        }
        return area;
    }

    public boolean notInArea(int m, int n, int x, int y) {
        return x < 0 || m <= x || y < 0 || n <= y;
    }

}
