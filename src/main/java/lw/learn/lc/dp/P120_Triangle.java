package lw.learn.lc.dp;

import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-04 11:42:42
 **/
public class P120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        //return minimumTotal(triangle, 0, 0);
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    /**
     * @param triangle
     * @param level
     * @param index
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle, int level, int index) {

        if (level == triangle.size() - 2) {
            return triangle.get(level).get(index) + Math.min(triangle.get(level + 1).get(index), triangle.get(level + 1).get(index + 1));
        }
        int res = triangle.get(level).get(index);
        int left = minimumTotal(triangle, level + 1, index);
        int right = minimumTotal(triangle, level + 1, index + 1);
        res += Math.min(left, right);
        return res;
    }
}
