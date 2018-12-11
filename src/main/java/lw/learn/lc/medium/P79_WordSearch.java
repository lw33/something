package lw.learn.lc.medium;


/**
 * @Author lw
 * @Date 2018-11-15 13:28:08
 **/
public class P79_WordSearch {

    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    private int m;    // row
    private int n;    // col
    private boolean[][] visited;
    private char[][] board;

    public boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;
        this.board = board;
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searh(i, j, 0, word))
                    return true;
            }
        }
        return false;
    }

    private boolean searh(int row, int col, int index, String word) {

        if (index == word.length() - 1) {
            return word.charAt(index) == board[row][col];
        }

        if (!visited[row][col] && word.charAt(index) == board[row][col]) {
            visited[row][col] = true;
            for (int i = 0; i < d.length; i++) {
                int newX = row + d[i][0];
                int newY = col + d[i][1];
                if (inArea(newX, newY) && !visited[newX][newY] && searh(newX, newY, index + 1, word)) {
                    return true;
                }
            }
            visited[row][col] = false;
        }

        return false;
    }

    private boolean inArea(int x, int y) {
        return x < m && x >= 0 && y < n && y >= 0;
    }
}
