package lw.learn.lc.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-12-03 13:57:16
 **/
// TODO: 2018/12/3 空间优化 
public class P289_GameOfLife {

    int[][] arounds = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    public void gameOfLife(int[][] board) {
        int[][] boardCopy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i],0, boardCopy[i], 0, board[i].length);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                changeStatus(board, boardCopy, i, j);
            }
        }
    }

    private void changeStatus(int[][] board, int[][] boardCopy, int i, int j) {
        int countOf1 = 0;
        for (int[] around : arounds) {
            int ax = i + around[0];
            int ay = j + around[1];
            if (inArea(board.length, board[0].length, ax, ay)) {
                if (boardCopy[ax][ay] == 1) {
                    countOf1++;
                }
            }
        }
        if (boardCopy[i][j] == 1) {
            board[i][j] = 0;
            if (countOf1 == 2 || countOf1 == 3) {
                board[i][j] = 1;
            }
        } else {
            if (countOf1 == 3) {
                board[i][j] = 1;
            }
        }
    }

    public boolean inArea(int m, int n, int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    @Test
    public void test() {
        int[][] cells = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        this.gameOfLife(cells);
        int[] arr1 = {1, 2, 3};
        int[] arr2 = new int[2];
        System.arraycopy(arr1, 0, arr2, 0, 2);
        System.out.println(Arrays.toString(arr2));
    }
}
