package lw.learn.lc.array;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-02-23 20:02:58
 **/
public class P498_DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0] == null) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int ax = 0;
        int ay = 0;
        int bx = 0;
        int by = 0;
        int endX = m - 1;
        int endY = n - 1;
        boolean up = true;
        int index = 0;
        while (ay <= endY) {
            index = findDiagonalOrder(matrix, res, index, ax, ay, bx, by, up);
            // 注意顺序 a 先加 y b 先加 x
            ay = ax == endX ? ay + 1 : ay;
            ax = ax == endX ? ax : ax + 1;
            bx = by == endY ? bx + 1 : bx;
            by = by == endY ? by : by + 1;
            up = !up;
        }
        return res;
    }

    private int findDiagonalOrder(int[][] matrix, int[] res, int index, int ax, int ay, int bx, int by, boolean up) {
        // 次数
        int times = by - ay;
        if (up) {
            for (int i = 0; i <= times; i++) {
                res[index++] = matrix[ax - i][ay + i];
            }
        } else {
            for (int i = 0; i <= times; i++) {
                res[index++] = matrix[bx + i][by - i];
            }
        }
        return index;
    }

    @Test
    public void test() {
        int[][] arr = JSON2Java.json2int2Array("[[1,2,3],[4,5,6],[7,8,9]]");
        int[] diagonalOrder = this.findDiagonalOrder(arr);
        System.out.println(Arrays.toString(diagonalOrder));
    }
}
