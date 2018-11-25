package lw.learn.p.z.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author lw
 * @Date 2018-11-22 19:32:19
 **/
public class ArrangeMeeting {

    class Meeting {

        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int maxArrange(Meeting[] meetings, int cur) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a.end));
        int res = 0;
        for (Meeting meeting : meetings) {
            if (meeting.start >= cur) {
                res++;
                cur = meeting.end;
            }
        }
        return res;
    }
}
