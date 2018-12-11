package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-11-15 16:08:52
 **/
public class P200_NumIslands {

    private int m;
    private int n;
    private boolean[][] visited;
    private char[][] grid;
    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    searhIands(i, j);
                    res++;
                }
            }
        }

        return 0;
    }

    private void searhIands(int row, int col) {
        visited[row][col] = true;
        for (int i = 0; i < d.length; i++) {
            int newX = row + d[i][0];
            int newY = col + d[i][1];
            if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
                searhIands(newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x < m && x >= 0 && y < n && y >= 0;
    }
}
