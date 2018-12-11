package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-12-03 13:42:35
 **/
public class P73_SetZeroes {

    public void setZeroes(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == 1) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < cols.length; i++) {
            if (cols[i] == 1) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
