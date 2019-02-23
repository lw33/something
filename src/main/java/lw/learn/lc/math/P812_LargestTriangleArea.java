package lw.learn.lc.math;

/**
 * @Author lw
 * @Date 2019-02-22 21:56:13
 **/
public class P812_LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {

        int m = points.length;
        double max = 0;
        for (int i = 0; i < m; i++) {
            int[] x = points[i];
            for (int j = 0; j < m; j++) {
                int[] y = points[j];
                for (int k = 0; k < m; k++) {
                    int[] z = points[k];
                    max = Math.max(max, 0.5 * (x[0] * y[1] + y[0] * z[1] + z[0] * x[1] - x[0] * z[1] - y[0] * x[1] - z[0] * y[1]));
                }
            }
        }
        return max;
    }
}
