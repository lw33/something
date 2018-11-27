package lw.learn.p.z.array;

/**
 * @Author lw
 * @Date 2018-11-27 15:09:36
 **/
public class ToMatrixRightBottom {

    public int walk(int[][] matirx, int i, int j) {
        if (i == matirx.length - 1 && j == matirx[0].length - 1) {
            return matirx[i][j];
        }

        if (i == matirx.length - 1) {
            return matirx[i][j] + walk(matirx, i, j + 1);
        }

        if (j == matirx[0].length - 1) {
            return matirx[i][j] + walk(matirx, i + 1, j);
        }

        int right = walk(matirx, i, j + 1);
        int down = walk(matirx, i + 1, j);
        return matirx[i][j] + Math.min(right, down);

    }
}
