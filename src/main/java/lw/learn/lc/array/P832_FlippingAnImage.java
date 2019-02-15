package lw.learn.lc.array;

/**
 * @Author lw
 * @Date 2019-02-14 23:16:45
 **/
public class P832_FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return A;
        }
        int m = A.length;
        int n = A[0].length;
        int[][] newA = new int[m][n];

        for (int i = 0; i < m; i++) {
            int aj = 0;
            for (int j = n - 1; j >= 0; j--) {
                newA[i][aj++] = A[i][j] == 0 ? 1 : 0;
            }
        }
        return newA;
    }
}
