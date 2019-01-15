package lw.learn.lc.math;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-14 21:45:41
 **/
public class P976_LargestPerimeterTriangle {

    /**
     * 排序数组。对于数组内任意的 cc，我们选择满足条件的最大的 a≤b≤c，也就是大到小排序，位于 c 后面的两个元素。
     * 从大到小枚举 c，如果能组成三角形的话，我们就返回答案。
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {

        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i + 1] + A[i] > A[i+2]) {
                return A[i + 1] + A[i + 2] + A[i];
            }
        }

        return 0;
    }
}
