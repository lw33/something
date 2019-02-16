package lw.learn.lc.array;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-15 18:45:30
 **/
public class P766_ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length <= 1 || matrix[0].length <= 1) {
            return true;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 2;
        boolean zero = false;
        while (!zero || i != n - 1) {
            if (i == 0) {
                zero = true;
            }
            if (isEqual(matrix, m, n, i, zero)) {
                if (zero) {
                    i++;
                } else {
                    i--;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isEqual(int[][] matrix, int m, int n, int x, boolean zero) {
        int i = 0;
        int j = 0;
        if (zero) {
            j = x;
        } else {
            i = x;
        }
        int pre = matrix[i][j];
        while (i < m && j < n) {
            if (pre != matrix[i++][j++]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[][] arr = JSON2Java.json2int2Array("[[18],[66]]");
        System.out.println(this.isToeplitzMatrix(arr));
    }
}
