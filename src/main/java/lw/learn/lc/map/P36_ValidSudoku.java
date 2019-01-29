package lw.learn.lc.map;

import java.util.HashSet;

/**
 * @Author lw
 * @Date 2019-01-15 18:27:10
 **/
public class P36_ValidSudoku {


    public boolean isValidSudoku(char[][] board) {

        int m = board.length;
        int n = board.length;

        HashSet<Character> rowSet = new HashSet<>();
        HashSet<Character> colSet = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowSet.contains(board[i][j]) || colSet.contains(board[j][i])) {
                    return false;
                } else {
                    if (board[i][j] != '.') {
                        rowSet.add(board[i][j]);
                    }
                    if (board[j][i] != '.') {
                        colSet.add(board[j][i]);
                    }
                }
            }
            rowSet.clear();
            colSet.clear();
        }

        for (int i = 0; i < m; i += 3) {
            for (int j = 0; j < n; j += 3) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        char c = board[i + k][j + l];
                        if (c != '.') {
                            if (rowSet.contains(c)) {
                                return false;
                            }
                            rowSet.add(board[i + k][j + l]);
                        }
                    }
                }
                rowSet.clear();
            }
        }

        return true;
    }
}
