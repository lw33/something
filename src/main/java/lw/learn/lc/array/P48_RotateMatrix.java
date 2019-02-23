package lw.learn.lc.array;

/**
 * @Author lw
 * @Date 2018-11-20 20:15:10
 * @tag medium
 **/
public class P48_RotateMatrix {

    public void rotate(int[][] matrix) {
        if (matrix.length == 0) return;
        int tx = 0;
        int ty = 0;
        int bx = matrix.length - 1;
        int by = matrix.length - 1;
        while (tx < bx) {
            rotate(matrix, tx++, ty++, bx--, by--);
        }
    }

    /**
     * @param matrix
     * @param tx     左上 x
     * @param ty     左上 y
     * @param bx     右下 x
     * @param by     右下 y
     */
    private void rotate(int[][] matrix, int tx, int ty, int bx, int by) {
        int times = bx - tx;
        int tmp;
        for (int i = 0; i < times; i++) {
            // 转一圈。。。
            tmp = matrix[bx - i][ty];
            matrix[bx - i][ty] = matrix[bx][by - i];
            matrix[bx][by - i] = matrix[tx + i][by];
            matrix[tx + i][by] = matrix[tx][ty + i];
            matrix[tx][ty + i] = tmp;
        }
    }
}
