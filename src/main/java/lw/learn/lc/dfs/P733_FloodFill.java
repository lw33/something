package lw.learn.lc.dfs;

/**
 * @Author lw
 * @Date 2019-02-12 12:52:22
 **/
public class P733_FloodFill {

    public static final int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m, n;
    int oldValue;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (newColor == image[sr][sc]) {
            return image;
        }
        oldValue = image[sr][sc];
        m = image.length;
        n = image[0].length;
        dfs(image, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor) {

        image[sr][sc] = newColor;
        for (int[] around : d) {
            int newSr = sr + around[0];
            int newSc = sc + around[1];
            if (inArea(newSr, newSc) && image[newSr][newSc] == oldValue) {
                dfs(image, newSr, newSc, newColor);
            }
        }
    }

    private boolean inArea(int newSr, int newSc) {
        return newSr >= 0 && newSc >= 0 && newSr < m && newSc < n;
    }

}
