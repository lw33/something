package lw.learn.offer;

import org.junit.Test;
/**
 * @Author lw
 * @Date 2018-10-04 18:59:04
 * <p>
 * 题目描述
 * * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * * a b c e s f c s a d e e
 * * 0 1 2 3 4 5 6 7 8 9 10 11
 * * a  b  c  e
 * * s  f  c  s
 * * a  d  e  e
 **/
public class P65_HasPathInMatrix {
    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || str == null || str.length == 0) {
            return false;
        }
        boolean[] visited = new boolean[matrix.length];
        int index = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (searchWord(matrix, rows, cols, row, col, str, index, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[] matrix, int rows, int cols, int row, int col, char[] str, int index, boolean[] visited) {

        if (index == str.length-1) {
            return matrix[row * cols + col] == str[index];
        }
        if (matrix[row * cols + col] == str[index]) {
            visited[row * cols + col] = true;
            for (int i = 0; i < d.length; i++) {
                int newRow = row + d[i][0];
                int newCol = col + d[i][1];
                if (inArea(newRow, newCol, rows, cols) && !visited[newRow * cols + newCol] && searchWord(matrix, rows, cols, newRow, newCol, str, index + 1, visited)) {
                    return true;
                }
            }
            visited[row * cols + col] = false;

        }
        return false;
    }
    public boolean inArea(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }


    @Test
    public void test() {
        String str = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
        System.out.println(this.hasPath(str.toCharArray(), 5, 8, "SLHECCEIDEJFGGFIE".toCharArray()));
    }
}
