package lw.learn.lc.array;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-23 19:44:08
 **/
public class P59_SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        } else if (n == 1) {
            return new int[][]{{1}};
        }
        int[][] res = new int[n][n];
        int tx = 0;
        int ty = 0;
        int bx = n - 1;
        int by = n - 1;
        int start = 1;
        while (tx < bx) {
            int count = (bx - tx - 1) * 4 + 4;
            generateMatrix(res, start, tx++, ty++, bx--, by--);
            start += count;
        }
        if (bx == tx) res[bx][by] = n * n;
        return res;
    }

    private void generateMatrix(int[][] res, int start, int tx, int ty, int bx, int by) {
        int curX = tx;
        int curY = ty;
        while (curY < by) {
            res[curX][curY++] = start++;
        }
        while (curX < bx) {
            res[curX++][curY] = start++;
        }
        while (curY > ty) {
            res[curX][curY--] = start++;
        }
        while (curX > tx) {
            res[curX--][curY] = start++;
        }
    }

    @Test
    public void test() {
        this.generateMatrix(2);
    }
}
