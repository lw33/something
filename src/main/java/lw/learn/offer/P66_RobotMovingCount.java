package lw.learn.offer;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-04 19:00:50
 * <p>
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 **/
public class P66_RobotMovingCount {


    public int movingCount(int threshold, int rows, int cols) {

        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        boolean[] visited = new boolean[rows*cols];

        return move(rows, cols, 0, 0, threshold, visited);
    }

    public int move(int rows, int cols, int row, int col, int threshold, boolean[] visited) {

        if (canVisite(rows, cols, row, col, threshold, visited)) {
            visited[row * cols + col] = true;

            return 1 + move(rows, cols, row - 1, col, threshold, visited)
                    + move(rows, cols, row, col + 1, threshold, visited)
                    + move(rows, cols, row + 1, col, threshold, visited)
                    + move(rows, cols, row, col - 1, threshold, visited);
        }
        return 0;
    }

    private boolean canVisite(int rows, int cols, int row, int col, int threshold, boolean[] visited) {
        int sum = 0;
        int tmpRow = row;
        int tmpCol = col;
        while (tmpRow > 0) {
            sum += tmpRow % 10;
            tmpRow /= 10;
        }
        while (tmpCol > 0) {
            sum += tmpCol % 10;
            tmpCol /= 10;
        }
        return sum <= threshold && inArea(row, col, rows, cols) && !visited[row * cols + col];
    }

    private boolean inArea(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }


    @Test
    public void test() {
        System.out.println(this.movingCount(18, 3, 3));

    }
}
