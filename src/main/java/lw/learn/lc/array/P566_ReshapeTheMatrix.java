package lw.learn.lc.array;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-10 23:31:23
 **/
public class P566_ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0) {
            return nums;
        }
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] newMarix = new int[r][c];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newMarix[index / c][index % c] = nums[i][j];
                ++index;
            }
        }
        return newMarix;
    }
    
    @Test
    public void test() {
        int[][] arr = JSON2Java.json2int2Array("[[1,2],[3,4]]");
        int[][] ints = this.matrixReshape(arr, 1, 4);
        System.out.println(Arrays.deepToString(ints));
    }
}
