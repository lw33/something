package lw.learn.lc.sort;

import lw.learn.lc.ds.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-23 22:47:41
 **/
public class P57_InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }

        if (intervals.get(0).start > newInterval.end) {
            res.add(newInterval);
            res.addAll(intervals);
        } else if (intervals.get(intervals.size() - 1).end < newInterval.start) {
            res.addAll(intervals);
            res.add(newInterval);
        } else {

            int i = 0;
            while (i < intervals.size()) {

                Interval interval = intervals.get(i);
                if (interval.end < newInterval.start) {
                    res.add(interval);
                    i++;

                } else {

                    int start = Math.min(interval.start, newInterval.start);
                    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
                        i++;
                    }

                    int end;
                    if (i > 0) {
                        end = Math.max(newInterval.end, intervals.get(i - 1).end);
                    } else {
                        end = Math.max(newInterval.end, intervals.get(0).end);
                        i++;
                    }
                    res.add(new Interval(start, end));
                    break;
                }
            }
            while (i < intervals.size()) {
                res.add(intervals.get(i));
                i++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        List<Interval> intervals = new ArrayList<>();
        //intervals.add(new Interval(3, 5));
        //intervals.add(new Interval(12, 15));
        intervals.add(new Interval(1, 5));
        System.out.println(this.insert(intervals, new Interval(2, 3)));
    }
}
