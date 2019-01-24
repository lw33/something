package lw.learn.lc.sort;

import lw.learn.lc.ds.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-08 21:09:03
 **/
public class P56_MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> res = new ArrayList<>();

        if (intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        Interval interval = new Interval();
        interval.start = intervals.get(0).start;
        interval.end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= interval.end) {
                interval.end = intervals.get(i).end > interval.end ? intervals.get(i).end : interval.end;
            } else {
                res.add(interval);
                interval = new Interval();
                interval.start = intervals.get(i).start;
                interval.end = intervals.get(i).end;
            }
        }
        res.add(interval);
        return res;
    }


}
