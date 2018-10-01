package lw.learn.offer;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Author lw
 * @Date 2018-10-01 20:07:49
 *
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 **/
public class P19_PrintMatrix {

    public ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int topX = 0;

        int topY = 0;

        int downX = matrix.length - 1;

        int downY = matrix[0].length - 1;

        while (topX <= downX && topY <= downY) {
            print(matrix, topX++, topY++, downX--, downY--, res);
        }
        return res;
    }

    public void print(int[][] matrix, int topX, int topY, int downX, int downY, ArrayList<Integer> res) {

        if (topX == downX) {
            for (int i = topY; i <= downY; i++) {
                res.add(matrix[topX][i]);
            }
        } else if (topY == downY) {
            for (int i = topX; i <= downX; i++) {
                res.add(matrix[i][topY]);
            }
        } else {

            int curX = topX;
            int curY = topY;

            while (curY < downY) {
                res.add(matrix[curX][curY++]);
            }

            while (curX < downX) {
                res.add(matrix[curX++][curY]);
            }

            while (curY > topY) {
                res.add(matrix[curX][curY--]);
            }

            while (curX > topX) {
                res.add(matrix[curX--][curY]);
            }
        }
    }
}
