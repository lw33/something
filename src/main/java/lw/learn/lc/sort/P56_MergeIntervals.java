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
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).end >= intervals.get(i + 1).start) {

            } else {
            }
        }
        return res;
    }
}
