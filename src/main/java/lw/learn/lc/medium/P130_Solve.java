package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-12-12 00:14:20
 **/
public class P130_Solve {

    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void solve(char[][] board) {

        if (board == null || board.length < 2 || board[0].length < 2) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        // 只要最外层有零 则那片区域就不能修改
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O' && !visited[0][i]) {
                visited(board, 0, i, visited);
            }
            if (board[m - 1][i] == 'O' && !visited[m - 1][i]) {
                visited(board, m - 1, i, visited);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                visited(board, i, 0, visited);
            }
            if (board[i][n - 1] == 'O' && !visited[i][n - 1]) {
                visited(board, i, n - 1, visited);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void visited(char[][] board, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        for (int i = 0; i < d.length; i++) {
            int newX = row + d[i][0];
            int newY = col + d[i][1];
            if (inArea(board.length, board[0].length, newX, newY) && !visited[newX][newY] && board[newX][newY] == 'O') {
                visited(board, newX, newY, visited);
            }
        }
    }

    private boolean inArea(int m, int n, int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}
