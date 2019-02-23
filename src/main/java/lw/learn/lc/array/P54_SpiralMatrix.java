package lw.learn.lc.array;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-23 19:06:19
 **/
public class P54_SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int tx = 0;
        int ty = 0;
        int bx = matrix.length - 1;
        int by = matrix[0].length - 1;
        while (tx <= bx && ty <= by) {
            spiralOrder(matrix, res, tx++, ty++, bx--, by--);
        }
        return res;
    }

    private void spiralOrder(int[][] matrix, List<Integer> res, int tx, int ty, int bx, int by) {
        if (tx == bx) {
            for (int i = ty; i <= by; i++) {
                res.add(matrix[tx][i]);
            }
        } else if (ty == by) {
            for (int i = tx; i <= bx; i++) {
                res.add(matrix[i][ty]);
            }
        } else {
            int curX = tx;
            int curY = ty;
            while (curY < by) {
                res.add(matrix[curX][curY++]);
            }
            while (curX < bx) {
                res.add(matrix[curX++][curY]);
            }
            while (curY > ty) {
                res.add(matrix[curX][curY--]);
            }
            while (curX > tx) {
                res.add(matrix[curX--][curY]);
            }
        }
    }

    @Test
    public void test() {
        int[][] arr = JSON2Java.json2int2Array("[[3],[2]]");
        this.spiralOrder(arr);
    }
}
