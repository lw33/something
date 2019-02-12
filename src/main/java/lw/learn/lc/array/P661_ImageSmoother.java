package lw.learn.lc.array;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-02-12 09:43:06
 **/
public class P661_ImageSmoother {

    public static int[][] d = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    private int m = 0;
    private int n = 0;

    public int[][] imageSmoother(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return M;
        }

        m = M.length;
        n = M[0].length;
        // 坑
        int[][] newM = new int[m][];
        for (int i = 0; i < m; i++) {
            newM[i] = Arrays.copyOf(M[i], n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                smooth(M, newM, i, j);
            }
        }

        return newM;
    }

    private void smooth(int[][] m, int[][] newM, int i, int j) {
        int count = 1;
        int sum = m[i][j];
        for (int k = 0; k < d.length; k++) {
            int newX = i + d[k][0];
            int newY = j + d[k][1];
            if (inArea(newX, newY)) {
                count++;
                sum += m[newX][newY];
            }
        }
        newM[i][j] = sum / count;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    @Test
    public void test() {
        int[][] arr = JSON2Java.json2int2Array("[[2,3,4],[5,6,7],[8,9,10],[11,12,13],[14,15,16]]");
        int[][] ints = this.imageSmoother(arr);
        System.out.println(Arrays.deepToString(ints));
    }
}
