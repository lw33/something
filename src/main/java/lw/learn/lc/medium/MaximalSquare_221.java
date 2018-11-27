package lw.learn.lc.medium;

import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-11-27 14:51:48
 **/
public class MaximalSquare_221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int maxArea = 0;
        int[] height;
        height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maximalSquareFromBottom(height), maxArea);
        }
        return maxArea;
    }

    private int maximalSquareFromBottom(int[] height) {

        if (height == null || height.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                maxArea = getMaxArea(height, stack, maxArea, i);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            maxArea = getMaxArea(height, stack, maxArea, height.length);
        }
        return maxArea;
    }

    private int getMaxArea(int[] height, Stack<Integer> stack, int maxArea, int end) {
        int j = stack.pop();
        int k = stack.isEmpty() ? -1 : stack.peek();
        int b = Math.min(end - k - 1, height[j]);
        int curArea = b * b;
        maxArea = Math.max(curArea, maxArea);
        return maxArea;
    }
}
