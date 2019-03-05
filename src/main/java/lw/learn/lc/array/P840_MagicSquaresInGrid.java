package lw.learn.lc.array;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-03-04 21:35:08
 **/
public class P840_MagicSquaresInGrid {

    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        int m = grid.length - 2;
        int n = grid[0].length - 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isMagicSquare(grid, i, j, i + 2, j + 2)) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean isMagicSquare(int[][] grid, int tx, int ty, int bx, int by) {

        int[] map = new int[10];
        int target = 0;
        for (int i = 0; i < 3; i++) {
            target += grid[tx][ty + i];
        }
        for (int i = 0; i < 3; i++) {
            int sumX = 0;
            int sumY = 0;
            for (int j = 0; j < 3; j++) {
                int x = tx + i;
                int y = ty + j;
                if (grid[x][y] > 9 || grid[x][y] < 1) {
                    return false;
                }
                if (map[grid[x][y]] != 0) {
                    return false;
                }
                map[grid[x][y]] = 1;
                sumX += grid[x][y];
            }
            if (sumX != target) {
                return false;
            }
            for (int j = 0; j < 3; j++) {
                sumY += grid[tx + j][ty + i];
            }
            if (sumY != target) {
                return false;
            }
        }
        int ld = grid[tx][ty] + grid[tx + 1][ty + 1] + grid[bx][by];
        if (ld != target) {
            return false;
        }
        int rd = grid[tx][by] + grid[tx + 1][ty + 1] + grid[bx][ty];
        if (rd != target) {
            return false;
        }
        return true;
    }

    @Test
    public void test() {
        int[][] arr = JSON2Java.json2int2Array("[[4,3,8,4],[9,5,1,9],[2,7,6,2]]");
        System.out.println(this.numMagicSquaresInside(arr));
    }
}
