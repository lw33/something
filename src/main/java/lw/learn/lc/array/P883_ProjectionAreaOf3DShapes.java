package lw.learn.lc.array;

/**
 * @Author lw
 * @Date 2019-03-05 22:32:04
 **/
public class P883_ProjectionAreaOf3DShapes {

    /**
     * 三个面
     * 底下看 存在大于零的值
     * 侧面看 每一行中最大的值
     * 前面看 每一列中的最大的值
     *
     * @param grid
     * @return
     */
    public int projectionArea(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            int rowMax = 0;
            int colMax = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    res++;
                }
                rowMax = rowMax < grid[i][j] ? grid[i][j] : rowMax;
                colMax = colMax < grid[j][i] ? grid[j][i] : colMax;
            }
            res += rowMax + colMax;
        }
        return res;
    }

}
