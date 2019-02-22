package lw.learn.lc.dfs;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-02-22 15:15:31
 **/
public class P37_SudokuSolver {

    /**
     * 递归回溯 记录每一行 每一列 每一个小矩阵中 已经放置的数 如果接下来的数没有放过
     * 则可放入 直到最后一行结束
     * 如果不能到结束 则将放入的数取出 尝试 其他数
     */
    // 使用位运算记录每一行 每一列 每一个小矩阵中的存放情况
    // row[0] -> 110 --> 第零行已经放了 1 和 2 其他的同理
    //           2 1 0
    int[] row, col, matrix;
    // 数字数组
    int[][] b;

    public void solveSudoku(char[][] board) {
        int m = board.length;
        row = new int[m];
        col = new int[m];
        matrix = new int[m];
        b = new int[m][m];

        // 将字符数组转成数字数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '.') {
                    b[i][j] = 0;
                } else {
                    b[i][j] = board[i][j] - '0';
                }
            }
        }

        // 标记当前放置情况
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (b[i][j] > 0) {
                    // 行
                    row[i] |= 1 << b[i][j];
                    // 列
                    col[j] |= 1 << b[i][j];
                }
            }
        }
        // 每个小矩阵
        for (int i = 0; i < m; i += 3) {
            for (int j = 0; j < m; j += 3) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (b[i + k][j + l] > 0) {
                            matrix[(i / 3) * 3 + j / 3] |= 1 << b[i + k][j + l];
                        }
                    }
                }
            }
        }
        // 从 0, 0 开始填矩阵
        dfs(0, 0, board);
    }

    private boolean dfs(int i, int j, char[][] board) {
        if (i == 9) {
            // 最后一行遍历完成 得结果 改数组
            for (int k = 0; k < 9; k++) {
                for (int l = 0; l < 9; l++) {
                    board[k][l] = (char) (b[k][l] + '0');
                }
            }
            return true;
        }
        // 下一个目标
        // row
        int nextI = i;
        // col
        int nextJ = j + 1;
        // 如果下一个目标已经到了一行的末尾 则跳到下一行
        if (nextJ == 9) {
            nextI++;
            nextJ = 0;
        }
        // 如果当前行未填数字
        if (b[i][j] == 0) {
            // 从 1 开始 试
            for (int k = 1; k <= 9; k++) {
                // 转为 二进制的位置
                int val = 1 << k;
                // 计算 小矩阵的坐标 下面多处用到
                int mIndex = (i / 3) * 3 + j / 3;
                // 判断 行 列 小矩阵 是否存在当前数
                if ((row[i] & val) == 0 && (col[j] & val) == 0 && (matrix[mIndex] & val) == 0) {
                    // 不存在
                    // 填入数字
                    b[i][j] = k;
                    row[i] ^= val;
                    col[j] ^= val;
                    matrix[mIndex] ^= val;

                    // dfs 结果正确 出答案
                    if (dfs(nextI, nextJ, board)) {
                        return true;
                    }
                    // 结果为错 将数拿出
                    b[i][j] = 0;
                    row[i] ^= val;
                    col[j] ^= val;
                    matrix[mIndex] ^= val;
                }
            }
        } else {
            // 已填数字 进下一个坐标
            return dfs(nextI, nextJ, board);
        }
        // 当前位置 所有的尝试都不行
        return false;
    }

    @Test
    public void test() {
        char[][] chars = JSON2Java.json2char2Array("[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]");
        this.solveSudoku(chars);
        System.out.println(Arrays.deepToString(chars));
    }
}
