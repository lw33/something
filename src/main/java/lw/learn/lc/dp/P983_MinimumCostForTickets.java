package lw.learn.lc.dp;

import lw.learn.utils.LCUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-02-25 23:13:42
 **/
public class P983_MinimumCostForTickets {

    //输入：days = [1,4,6,7,8,20], costs = [2,7,15]
    //输出：11
    public static int[] durations = {1, 7, 30};
    int[][] memo;

    public int mincostTickets(int[] days, int[] costs) {
        memo = new int[days.length][30];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        int res = mincostTickets(days, costs, 0, 0);
        return res;
    }

    private int mincostTickets(int[] days, int[] costs, int index, int duration) {
        if (index == days.length) {
            return 0;
        }
        if (memo[index][duration] != -1) {
            return memo[index][duration];
        }
        int newDuration = 0;
        if (duration != 0) {
            // 减去前面过去的时间
            newDuration = duration - (days[index] - days[index - 1]) + 1;
        }
        int res = Integer.MAX_VALUE;
        if (newDuration > 0) {
            // 减去当天花费
            res = Math.min(res, mincostTickets(days, costs, index + 1, newDuration - 1));
        } else {
            // 循环控制
            for (int i = 0; i < costs.length; i++) {
                res = Math.min(res, costs[i] + mincostTickets(days, costs, index + 1, durations[i] - 1));
            }
        }
        memo[index][duration] = res;
        return res;
    }


    int[][] memoII;

    public int mincostTicketsII(int[] days, int[] costs) {
        memoII = new int[days.length][366];
        return mincostTicketsII(days, costs, 0, 0);
    }

    private int mincostTicketsII(int[] days, int[] costs, int index, int day) {
        if (index == days.length) {
            return 0;
        }
        if (memoII[index][day] != 0) {
            return memoII[index][day];
        }
        int res = Integer.MAX_VALUE;
        if (day >= days[index]) {
            res = mincostTicketsII(days, costs, index + 1, day);
        } else {
            for (int i = 0; i < costs.length; i++) {
                day = days[index] + durations[i] - 1;
                day = day > 365 ? 365 : day;
                res = Math.min(res, costs[i] + mincostTicketsII(days, costs, index + 1, day));
            }
        }
        memoII[index][day] = res;
        return res;
    }

    public int mincostTicketsDP(int[] days, int[] costs) {
        int[][] dp = new int[days.length + 1][366];
        for (int i = days.length - 1; i >= 0; i--) {
            for (int j = 0; j < 366; j++) {
                if (j >= days[i]) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    int res = Integer.MAX_VALUE;
                    for (int k = 0; k < costs.length; k++) {
                        int day = days[i] + durations[k] - 1;
                        day = day > 365 ? 365 : day;
                        res = Math.min(res, costs[k] + dp[i + 1][day]);
                    }
                    dp[i][j] = res;
                }
            }
        }
        return dp[0][0];
    }

    @Test
    public void test() {
        int[] days = LCUtils.stringToIntegerArray("[1,4,6,7,8,20]");
        int[] costs = LCUtils.stringToIntegerArray("[2,7,15]");
        System.out.println(this.mincostTickets(days, costs));
        System.out.println(this.mincostTicketsII(days, costs));
        System.out.println(this.mincostTicketsDP(days, costs));
    }
}
