package lw.learn.lc.medium;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-28 16:44:13
 **/
public class P120_MinimumTotal {

    int min = Integer.MAX_VALUE;
    HashMap<String, Integer> memo = new HashMap<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public int minimumTotal(List<List<Integer>> triangle, int level, int index) {
        if (memo.containsKey(level + "_" + index))
            return memo.get(level + "_" + index);
        System.out.println("level " + level + " index " + index + " num " + triangle.get(level).get(index));
        if (level == triangle.size() - 2) {
            return triangle.get(level).get(index) + Math.min(triangle.get(level+ 1).get(index), triangle.get(level + 1).get(index + 1));
        }
        int res = triangle.get(level).get(index);
        int left = minimumTotal(triangle, level + 1, index);
        System.out.println(level);
        int right = minimumTotal(triangle, level + 1, index + 1);
        res += Math.min(left, right);
        memo.put(level + "_" + index, res);
        return res;
    }
    public int minimumTotal(List<List<Integer>> triangle, int level, int index, int sum) {
        if (level == triangle.size()) {
            min = Math.min(min, sum);
            return min;
        }

        int left = minimumTotal(triangle, level + 1, index, sum + triangle.get(level).get(index));
        int right = Integer.MAX_VALUE;
        if (index + 1 < triangle.get(level).size()) {
            right = minimumTotal(triangle, level + 1, index + 1, sum + triangle.get(level).get(index + 1));
        }
        int res = Math.min(left, right);
        return res;
    }

    @Test
    public void test() {
        List<List> jsonArray = JSON.parseArray("[\n" + "     [2],\n" + "    [3,4],\n" + "   [6,5,7],\n" + "  [4,1,8,3]\n" + "]", List.class);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            List<Integer> list = new ArrayList<>();
            for (Object o : jsonArray.get(i)) {
                list.add((Integer) o);
            }
            lists.add(list);
        }
        System.out.println(this.minimumTotal(lists));
    }
}
