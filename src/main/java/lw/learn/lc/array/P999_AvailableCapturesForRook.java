package lw.learn.lc.array;

/**
 * @Author lw
 * @Date 2019-03-03 23:09:12
 **/
public class P999_AvailableCapturesForRook {

    public int numRookCaptures(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return 0;
        }
        int m = board.length;
        int n = board[0].length;
        int iR = 0;
        int jR = 0;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    iR = i;
                    jR = j;
                    break;
                }
            }
        }

        for (int i = iR - 1; i >= 0; i--) {
            if (board[i][jR] == 'p') {
                res++;
                break;
            } else if (board[i][jR] == 'B') {
                break;
            }
        }
        for (int i = jR + 1; i < n; i++) {
            if (board[iR][i] == 'p') {
                res++;
                break;
            } else if (board[iR][i] == 'B') {
                break;
            }
        }
        for (int i = iR + 1; i < m; i++) {
            if (board[i][jR] == 'p') {
                res++;
                break;
            } else if (board[i][jR] == 'B') {
                break;
            }
        }
        for (int i = jR - 1; i >= 0; i--) {
            if (board[iR][i] == 'p') {
                res++;
                break;
            } else if (board[iR][i] == 'B') {
                break;
            }
        }

        return res;
    }
}
