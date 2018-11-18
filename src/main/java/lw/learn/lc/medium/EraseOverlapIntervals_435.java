package lw.learn.lc.medium;

import lw.learn.lc.ds.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author lw
 * @Date 2018-11-18 12:03:45
 **/
public class EraseOverlapIntervals_435 {

    // dp
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length < 2)
            return 0;
        Comparator<Interval> comparator = (i1, i2) -> {
            if (i1.start != i2.start)
                return i1.start - i2.start;
            else
                return i1.end - i2.end;
        };

        Arrays.sort(intervals, comparator);

        int[] dp = new int[intervals.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i].start >= intervals[j].end)
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            if (max < dp[i])
                max = dp[i];
        }

        return intervals.length - max;
    }

    // greedy
    public int eraseOverlapIntervalsII(Interval[] intervals) {
        if (intervals == null || intervals.length < 2)
            return 0;
        Comparator<Interval> comparator = (i1, i2) -> {
            if (i1.start != i2.start)
                return i1.end - i2.end;
            else
                return i1.start - i2.start;
        };

        Arrays.sort(intervals, comparator);

        int res = 1;
        int pre = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= intervals[pre].end) {
                res++;
                pre = i;
            }
        }

        return intervals.length - res;
    }
}
